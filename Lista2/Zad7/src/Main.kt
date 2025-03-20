fun check(preambleLength: Int, list: List<Int>): Int {
    for (i in preambleLength until list.size) {
        val preamble = list.subList(i - preambleLength, i)
        val sprawdzanaliczba = list[i]
        var found = false

        for (j in 0 until preamble.size) {
            for (k in j + 1 until preamble.size) {
                if (preamble[j] + preamble[k] == sprawdzanaliczba) {
                    found = true
                    break
                }
            }
            if (found) break
        }

        if (!found) return sprawdzanaliczba
    }
    return -1
}

fun main(){
    println(check(2, listOf(1, 2, 3, 4, 5)))
    println(check(5, listOf(35, 25, 15, 25, 47, 40, 62, 55, 65, 95, 102, 117, 150, 182, 127, 219, 299, 277, 309, 576)))
}
