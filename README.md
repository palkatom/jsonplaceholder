# jsonplaceholder
Downloading posts from jsonplaceholder API

Simple project in Scala to download all posts from `https://jsonplaceholder.typicode.com` API.
All posts are written into single directory in JSON format. File name is `<post_id>.json`.

## Building and running

Project built with `sbt`. To run, use `sbt run` command.

## Configuration

There are two properties that can be configured. First is the host address (default: `https://jsonplaceholder.typicode.com`).
The second one is path to the output directory (default: `output`). You can change settings in `jsonplaceholder/Properties.scala` file.

## Packages

* `api` handles requests made to API. Main class in this package is `Handler` which provides two methods for getting posts: `getPost(id: Int)` and `getPosts()`
    In case of errors, simple HTTP error wrapper object in `Either`'s `Left` value is returned. In case of success, `Post` object of `List` of `Post`s are returned.
* `io` is responsible for saving `Post`s to files. Output directory will be created if doesn't exist.
* `model` contains `Post` class definition.

The main class is `PostsDownloader`.
