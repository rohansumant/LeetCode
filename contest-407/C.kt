class Solution {
    fun maxOperations(s: String): Int {
        val n = s.length
        val buckets = IntArray(n)
        var prev = 1
        var cnt = 0
        for (i in n-1 downTo 0) {
            if (s[i] == '0' && prev != 0) {
                cnt++
            } else if (s[i] == '1') {
                buckets[i] = cnt
            }
            prev = s[i]-'0'
        }
        var ans = 0
        for (i in 0..<n) {
            if (s[i] == '1') ans += buckets[i]
        }
        return ans
    }
}
