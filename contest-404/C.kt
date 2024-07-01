class Solution {
    fun maximumLength(nums: IntArray, k: Int): Int {
        val n = nums.size
        var ans = 0
        val dp = Array(n) {
            IntArray(k)
        }
        for (i in 1..<n) {
            for (j in 0..<i) {
                val m = (nums[i]+nums[j])%k
                dp[i][m] = maxOf(dp[i][m], 1+dp[j][m])
                ans = maxOf(ans, dp[i][m])
                //println("$i $j $m ${dp[i][m]}")
            }
            //println("")
        }

        return ans+1
    }
}
