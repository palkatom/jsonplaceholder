package jsonplaceholder.api

import jsonplaceholder.model.Post
import jsonplaceholder.Properties.host

import sttp.client._
import sttp.client.json4s._
import sttp.model._
import org.json4s.native.Serialization

/*
 * Synchronous handler of jsonplaceholder API
 */
object Handler {
  implicit val serialization = Serialization
  implicit val backend = HttpURLConnectionBackend()

  private def sendReq[A](endpoint: String)(implicit m: Manifest[A]) =
    basicRequest
      .get(uri"$host".path(endpoint))
      .response(asJson[A])
      .send()

  private def handleResp[A](resp: Response[Either[ResponseError[Exception], A]]): Either[HttpErrorWrapper, A] = {
    resp.code match {
      case StatusCode.Ok => Right(resp.body.right.get)
      case _ => Left(HttpErrorWrapper(resp.code.code, resp.statusText))
    }
  }

  def getPost(id: Int): Either[HttpErrorWrapper, Post] = {
    (sendReq[Post] _ andThen handleResp)(s"posts/$id")
  }

  def getPosts: Either[HttpErrorWrapper, List[Post]] = {
    (sendReq[List[Post]] _ andThen handleResp)("posts")
  }
}
