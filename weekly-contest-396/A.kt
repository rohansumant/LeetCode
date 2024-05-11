class Solution {
    fun isValid(word: String): Boolean {
        return word.length > 2 &&
            word.filter{it !in 'a'..'z' && it !in 'A'..'Z' && it !in '0'..'9'}.length == 0 &&
            word.filter{it.lowercase() in "aeiou"}.length > 0 &&
            word.filter{it.toByte() >= 65 && it.lowercase() !in "aeiou"}.length > 0
    }
}
