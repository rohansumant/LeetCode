class Solution {
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {

        requirements.sortBy {it[0]}
        for (i in 1..<requirements.size) {
            if (requirements[i][0] < requirements[i-1][0]) return 0
        }

        val dp = Array(n) {
            IntArray(401)
        }
        val MOD = (1e9+7).toInt()
        val checkpoints = HashMap<Int,Int>()
        for ((u,v) in requirements) {
            checkpoints[u] = v
            if (v > (u*(u+1))/2) return 0
        }
        dp[0][0] = 1
        for (i in 1..<n) {
            for (j in 0..400) {
                for (k in 0..i) {
                    if (j+k <= 400) {
                        dp[i][j+k] = (dp[i][j+k] + dp[i-1][j]) % MOD
                    }
                }
            }
            if (i in checkpoints) {
                for (j in 0..400) if (j != checkpoints[i]!!) {
                    dp[i][j] = 0
                }
            }
        }

        return dp[n-1].sum()
    }
}
