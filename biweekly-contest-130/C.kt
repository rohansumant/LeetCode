class Solution {

    fun isBalanced(arr: IntArray): Boolean {
        val ls = arr.filter{
            it != 0
        }
        if (ls.isEmpty()) return true // empty string
        return ls.all {it == ls[0]}
    }

    fun minimumSubstringsInPartition(s: String): Int {
        val n = s.length
        val INF = (1e9).toInt()
        val dp = IntArray(n) {INF}
        fun dfs(ix: Int): Int {
            if (ix == n) return 0
            var ans = dp[ix]
            if (ans != INF) return ans
            val arr = IntArray(26)
            for (i in ix..n-1) {
                arr[s[i]-'a']++
                if (isBalanced(arr)) {
                    ans = min(ans, 1 + dfs(i+1))
                }
            }
            dp[ix] = ans
            return ans
        }

        return dfs(0)
    }
}
