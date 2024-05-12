class Solution {
    fun satisfiesConditions(grid: Array<IntArray>): Boolean {
        val r = grid.size
        val c = grid[0].size
        for (i in 0..c-1) {
            for (j in 0..r-1) {
                if(grid[j][i] != grid[0][i]) return false
            }
            if (i > 0 && grid[0][i] == grid[0][i-1]) return false
        }
        return true
    }
}
