import java.io.File

data class FileInfo(val name: String, val extension: String, val size: Double = 0.0)

fun main() {
    val currentDir = File(".")
    val files = mutableListOf<FileInfo>()
    currentDir
        .walkTopDown()
        .filter { it.isFile() }
        .forEach { files.add(FileInfo(it.nameWithoutExtension, it.extension, it.length().toDouble())) }
    files.forEach { println(it) }
}
