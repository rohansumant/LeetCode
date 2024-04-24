class Solution {
    fun minimumOperations(grid: Array<IntArray>): Int {
        val r = grid.size
        val c = grid[0].size
        val INF = 1e8.toInt()
        val dp = Array(c) {
            IntArray(10) {INF}
        }
        val colSum = Array(c) {
            IntArray(11) {0}
        }
        for (i in 0..r-1) {
            for (j in 0..c-1) {
                val e = grid[i][j]
                colSum[j][e]++
                colSum[j][10]++
            }
        }

        fun dfs(col: Int, num: Int): Int {
            if (col == -1) return 0
            var ans = dp[col][num]
            if (ans != INF) return ans
            val total = colSum[col][10]
            for (other in 0..9) if (other != num) {
                val base = total - colSum[col][other]
                ans = minOf(ans, base + dfs(col-1, other))
            }
            dp[col][num] = ans
            return ans
        }

        var ans = dfs(c-1, 0)
        for (i in 1..9) {
            ans = minOf(ans, dfs(c-1, i))
        }
        return ans
    }
}
