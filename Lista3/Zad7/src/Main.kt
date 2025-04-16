fun srt(lst: List<String>): List<Pair<Char, List<String>>> {
    return lst.filter { it.length % 2 == 0 }
        .groupBy { it.first() }
        .map { it.key to it.value }
}
fun main(){
println(srt(listOf("cherry", "blueberry", "citrus", "appple", "apricot", "banana", "coconut")))

}