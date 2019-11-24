package jsonplaceholder.io

import jsonplaceholder.model.Post
import jsonplaceholder.Properties.outputDirectory

/*
 * Handles writing `Post` object into file.
 */
object PostWriter {
  def savePost(post: Post) = {
    // file path is determined by `outputDirectory` from `Properties` class and post's id
    val postFilePath = s"$outputDirectory/${post.id}.json"
    val postFileContent = post.toJsonPretty
    File.write(postFilePath, postFileContent)
  }
}
