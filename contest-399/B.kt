class Solution {
    fun compressedString(word: String): String {
        var ix = 0
        val n = word.length
        val ans = StringBuilder()
        while (ix < n) {
            var i = ix
            while (i < n && word[i] == word[ix] && i-ix < 9) i++
            ans.append(i-ix, word[ix])
            ix = i
        }
        return ans.toString()
    }
}
