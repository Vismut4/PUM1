fun isPalindrome(word: String): Boolean {
    return word == word.reversed()
}

fun main() {
    val word = "abba"
    println(isPalindrome(word))
    val word2 = "illia"
    println(isPalindrome(word2))
}
