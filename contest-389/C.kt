class Solution {
    fun minimumDeletions(word: String, k: Int): Int {
        val ls = word.groupingBy{it}.eachCount().values.sorted()
        val n = ls.size
        val INF = 1e7.toInt()
        var dp = IntArray(30) {INF}

        //println(ls)

        fun dfs(ix: Int) : Int {
            if (ix == n) return 0
            if (dp[ix] != INF) return dp[ix]
            var currCost = 0
            for (i in ix..<n) {
                require(ls[i] >= ls[ix])
                val delta = ls[i] - ls[ix]
                currCost += if(delta > k) delta-k else 0
            }
            //println(currCost)
            dp[ix] = minOf(ls[ix] + dfs(ix+1), currCost)
            return dp[ix]
        }

        return dfs(0)
    }
}
