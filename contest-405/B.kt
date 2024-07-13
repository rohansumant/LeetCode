class Solution {
    fun validStrings(n: Int): List<String> {
        val ans = mutableListOf<String>()

        var accum = mutableListOf<Char>()
        fun dfs(cnt: Int, prevZero: Boolean) {
            if (cnt == n) {
                ans += accum.joinToString("")
                return
            }
            accum += '1'
            dfs(cnt+1, false)
            accum.removeLast()
            if (!prevZero) {
                accum += '0'
                dfs(cnt+1, true)
                accum.removeLast()
            }
        }

        dfs(0, false)
        return ans
    }
}
