package jsonplaceholder

import jsonplaceholder.api.Handler
import jsonplaceholder.io.PostWriter

object PostsDownloader extends App {
  Handler.getPosts match {
    case Left(error) => println(s"HttpError occurred: ${error.code}, message: ${error.message}")
    case Right(posts) => for (post <- posts) PostWriter.savePost(post)
  }
}
