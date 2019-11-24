package jsonplaceholder.io

import jsonplaceholder.model.Post
import jsonplaceholder.Properties.outputDirectory

object PostWriter {
  def savePost(post: Post) = {
    val postFilePath = s"$outputDirectory/${post.id}.json"
    val postFileContent = post.toJsonPretty
    File.write(postFilePath, postFileContent)
  }
}
