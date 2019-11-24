package jsonplaceholder.api

import org.scalatest.FlatSpec
import sttp.client.testing.SttpBackendStub
import sttp.model.StatusCode

class HandlerSpec extends FlatSpec {
  "API Handler" should "return object wrapped in Right value if no error occurred" in {
    implicit val testingBackend = SttpBackendStub.synchronous
      .whenRequestMatches(_.uri.path.endsWith(List("posts", "1")))
      .thenRespond("""{"id":1,"userId":1,"title":"post title","body":"post body"}""")
      .whenRequestMatches(_.uri.path.endsWith(List("posts")))
      .thenRespond("""[{"id":1,"userId":1,"title":"post title","body":"post body"}]""")
    val post = Handler.getPost(1)
    assert(post.right.get.id == 1)
    val posts = Handler.getPosts
    assert(posts.right.get(0).id == 1)
  }

  it should "return HTTP error wrapped in Left value in case of errors" in {
    implicit val testingBackend = SttpBackendStub.synchronous
      .whenRequestMatches(_.uri.path.endsWith(List("post", "200")))
      .thenRespondWithCode(StatusCode.NotFound)
    val error = Handler.getPost(200)
    assert(error.left.get.code == 404)
    assert(error.left.get.message == "Not Found")
  }
}
