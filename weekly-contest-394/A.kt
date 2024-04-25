class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val n = word.length
        val arr = IntArray(26)
        word.forEach {
            ch ->
            val ix = ch - if (ch.isLowerCase()) 'a' else 'A'
            arr[ix] = arr[ix] or if (ch.isLowerCase()) 1 else 2
        }
        return arr.filter{it == 3}.size
    }
}
