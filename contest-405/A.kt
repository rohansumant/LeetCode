class Solution {
    fun getEncryptedString(s: String, k: Int): String {
        val n = s.length
        val ans = CharArray(n)
        for (i in 0..<n) {
            ans[i] = s[(i+k)%n]
        }
        return ans.joinToString("")
    }
}
