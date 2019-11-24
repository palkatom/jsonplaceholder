package jsonplaceholder.io

import java.io._

object File {

  private implicit def str2File(path: String): File = new File(path)

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
