class Solution {
    fun doesAliceWin(s: String): Boolean {
        fun Char.isVowel(): Boolean {
            return this in "aeiou"
        }
        val n = s.length
        var v = 0
        for (i in 0..<n) {
            if (s[i].isVowel()) v++
        }
        return if (v > 0) true else false
    }
}
