class Solution {
    fun maxScore(grid: List<List<Int>>): Int {
        val r = grid.size; val c = grid[0].size;
        val INF = (3e8).toInt()
        val dp = Array(r) {
            Array(c) {
                IntArray(2) {-INF}
            }
        }
        fun dfs(x: Int, y:Int, forced: Int): Int {
            var ans = dp[x][y][forced]
            if (ans != -INF) return ans
            ans = if (forced == 1) -INF else 0
            for (i in x+1..r-1) ans = maxOf(ans, grid[i][y] - grid[x][y] + dfs(i, y, 0))
            for (i in y+1..c-1) ans = maxOf(ans, grid[x][i] - grid[x][y] + dfs(x, i, 0))
            dp[x][y][forced] = ans
            return ans
        }

        var ans = -INF
        for (i in 0..r-1) {
            for (j in 0..c-1) {
                ans = maxOf(ans, dfs(i, j, 1))
            }
        }
        return ans
    }
}
