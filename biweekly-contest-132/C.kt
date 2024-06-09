class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        val ahead = mutableMapOf<Int,Int>()
        val next = mutableMapOf<Int, MutableMap<Int,Int>>()
        for (i in n-1 downTo 0) {
            val e = nums[i]
            if (e !in ahead) ahead[e] = n
            if (e !in next) next[e] = mutableMapOf<Int,Int>()
            next[e]!![i] = ahead[e]!!
            ahead[e] = i
        }

        val dp = Array(n) {
            Array(k+1) {
                IntArray(2) { -1 }
            }
        }

        fun dfs(ix: Int, allowed: Int, mustTake: Int): Int {
            if (ix == n) {
                require(allowed >= 0)
                return 0
            }
            if (dp[ix][allowed][mustTake] != -1) return dp[ix][allowed][mustTake]
            val e = nums[ix]
            val nextIx = next[e]!![ix]!!
            var ans = if (mustTake == 0) dfs(ix+1, allowed, mustTake) else -1 // skip this number altogether
            ans = maxOf(ans, 1 + dfs(nextIx, allowed, 1)) // take this number and the same ahead
            if (allowed > 0 && nextIx != ix+1) {
                ans = maxOf(ans, 1 + dfs(ix+1, allowed-1, 0)) // different number
            }
            dp[ix][allowed][mustTake] = ans
            return ans
        }

        return (0..<n).map {
            dfs(it, k, 1)
        }.max()
    }
}
