package jsonplaceholder.model

import org.json4s.DefaultFormats
import org.json4s.native.Serialization.{
  write,
  writePretty
}

case class Post(
  id: Int,
  userId: Int,
  title: String,
  body: String
) {
  implicit private val formats = DefaultFormats
  def toJson = write(this)
  def toJsonPretty = writePretty(this)
}
