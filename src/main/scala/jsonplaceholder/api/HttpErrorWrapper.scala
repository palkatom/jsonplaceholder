package jsonplaceholder.api

/*
 * Simple wrapper of HTTP errors.
 */
case class HttpErrorWrapper (
  code: Int,
  message: String
)
