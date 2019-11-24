package jsonplaceholder.io

import java.io._

object File {

  // for easier using of file paths in this class
  // makes `filepath.getParent.mkdir()` below possible
  private implicit def str2File(path: String): File = new File(path)

  /*
   * Write `contents` to file identified by `filepath`.
   *
   * Creates file's parent directory if one doesn't exist.
   */
  def write(filepath: String, contents: String) = {
    filepath.getParent.mkdir()
    val bw = new BufferedWriter(new FileWriter(filepath))
    try {
      bw.write(contents)
    } catch {
      case ex: IOException =>
        println(s"Error occurred during saving $filepath: ${ex.getMessage}")
    } finally {
      bw.close()
    }
  }
}
