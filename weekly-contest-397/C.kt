ass Solution {
    // upsolved
    fun maxScore(grid: MutableList<MutableList<Int>>): Int {
        val r = grid.size
        val c = grid[0].size
        val INF = (4e8).toInt()

        fun get(x: Int, y: Int, dx: Int, dy: Int): Int {
            val nx = x-dx
            val ny = y-dy
            if (nx in (0..r-1) && ny in (0..c-1)) {
                return grid[nx][ny]
            }
            return INF
        }

        var ans = -INF
        for (i in 0..r-1) {
            for (j in 0..c-1) {
                val mn = minOf(get(i,j,1,0), get(i,j,0,1))
                if (mn == INF) continue
                ans = maxOf(ans, grid[i][j] - mn)
                grid[i][j] = minOf(mn, grid[i][j])
            }
        }
        return ans
    }
}
