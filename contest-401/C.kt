class Solution {
    fun maxTotalReward(rewardValues: IntArray): Int {
        val ls = rewardValues.groupBy{it}.keys.sorted()
        val n = ls.size

        //println("${ls}")
        val dp = HashMap<Int, IntArray>()

        fun dfs(rsum: Int, ix: Int): Int {
            if (ix == n) return 0
            if (rsum !in dp) dp[rsum] = IntArray(n) {-1}
            if (dp[rsum]!![ix] != -1) return dp[rsum]!![ix]
            var ans = dfs(rsum, ix+1)
            val e = ls[ix]
            var next = ls.binarySearch(rsum+e)
            if (next >= 0) next++
            else next = -next-1
            ans = maxOf(ans, e + dfs(rsum+e, next))
            dp[rsum]!![ix] = ans
            //println("$rsum $ix: $ans")
            return ans
        }

        return dfs(0,0)
    }
}
