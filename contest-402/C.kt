class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        val mp = HashMap<Int,Int>()
        power.forEach {
            mp[it] = 1 + (mp[it] ?: 0)
        }
        val ls = mp.keys.toList().sorted()
        val n = ls.size

        val dp = LongArray(n) {-1L}

        fun dfs(ix: Int): Long {
            if (ix == n) return 0L
            if (dp[ix] != -1L) return dp[ix]
            var ans = dfs(ix+1)
            val e = ls[ix]
            var nextIx = ix
            while(nextIx < n && (ls[nextIx]-e) <= 2) nextIx++
            ans = maxOf(ans, 1L*e*mp[e]!! + dfs(nextIx))
            dp[ix] = ans
            return ans
        }

        return dfs(0)
    }
}
