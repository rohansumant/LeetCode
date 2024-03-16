class Solution {
    fun maximumStrength(nums: IntArray, k: Int): Long {
        val n = nums.size
        val NINF = -1e15.toLong()
        val dp = Array(n) {
            Array(k+1) {
                LongArray(2) {NINF}
                } }
        dp[0][0][0] = 0
        dp[0][1][0] = NINF
        dp[0][1][1] = k.toLong() * nums[0]
        dp[0][0][1] = NINF
        for (i in 0..n-1) {
            dp[i][0][0] = 0
        }
        for (i in 1..n-1) {
            for (j in 1..minOf(i+1,k)) {
                val delta : Long = (k-j+1L) * (if (j % 2 == 1) 1 else -1)
                dp[i][j][1] = maxOf(dp[i-1][j-1][0],
                                    dp[i-1][j][1],
                                    dp[i-1][j-1][1]) + delta*nums[i]
                dp[i][j][0] = maxOf(dp[i-1][j][0], dp[i-1][j][1])
                //println("$i, $j, ${dp[i][j][0]}, ${dp[i][j][1]}")
            }
        }
        /*for (i in 0..n-1) {
            for (j in 0..minOf(i+1,k)) {
                println("$i, $j, ${dp[i][j][0]}, ${dp[i][j][1]}")
            }
        }*/
        return maxOf(dp[n-1][k][0], dp[n-1][k][1])
    }
}
