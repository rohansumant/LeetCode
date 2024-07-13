class Solution {
    fun numberOfSubmatrices(grid: Array<CharArray>): Int {
        val r = grid.size
        val c = grid[0].size
        val dp = Array(r) {
            Array(c) { IntArray (2) }
        }

        fun add(a1: IntArray, a2: IntArray, mul: Int = 1) {
            for (i in 0..<2) a1[i] += mul*a2[i]
        }

        var ans = 0
        for (i in 0..<r) {
            for(j in 0..<c) {
                if (j > 0) add(dp[i][j], dp[i][j-1])
                if (i > 0) add(dp[i][j], dp[i-1][j])
                if (i > 0 && j > 0) add(dp[i][j], dp[i-1][j-1], -1)
                if (grid[i][j] == 'X') dp[i][j][0] += 1
                else if (grid[i][j] == 'Y') dp[i][j][1] += 1
                if (dp[i][j][0] > 0 && dp[i][j][0] == dp[i][j][1]) ans++
            }
        }
        return ans
    }
}
