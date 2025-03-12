fun PascalTriangle(height: Int): List<List<Int>> {
    val triangle = mutableListOf<List<Int>>()

    for (i in 0 until height) {
        val row = MutableList(i + 1) { 1 }

        for (j in 1 until i) {
            row[j] = triangle[i - 1][j - 1] + triangle[i - 1][j]
        }

        triangle.add(row)
    }

    return triangle
}

fun printPascal(height: Int) {
    val triangle = PascalTriangle(height)

    for (row in triangle) {

        val spaces = " ".repeat(height - row.size)
        println(spaces + row.joinToString(" "))
    }
}

fun main() {
    val height: Int = 4
    printPascal(height)
}
