class Solution {

    val INF = 1e9.toInt()

    inner class Trie {
        val arr: Array<Trie?> = Array(26) {null}
        var cost: Int? = null
        fun add(word: String, cost: Int, ix: Int = 0) {
            if (ix == word.length) {
                this.cost = minOf(cost, this.cost ?: INF)
                return
            }
            val cix = word[ix]-'a'
            if (arr[cix] == null) {
                arr[cix] = Trie()
            }
            arr[cix]!!.add(word, cost, ix+1)
        }
    }

    fun minimumCost(target: String, words: Array<String>, costs: IntArray): Int {
        val n = target.length
        val tr = Trie()

        for (i in 0..<words.size) {
            tr.add(words[i], costs[i])
        }
        // println("${tr.arr[3]}")
        val dp = IntArray(n) {-1}

        fun dfs(ix: Int): Int {
            if (ix == n) return 0
            if (dp[ix] != -1) return dp[ix]

            var i = ix
            var tmp: Trie = tr
            var ans = INF
            while (i < n) {
                val cix = target[i]-'a'
                if (tmp.arr[cix] == null) break
                tmp = tmp.arr[cix]!!
                if (tmp.cost != null) { // a matching prefix found
                    // println("$ix $i ${tmp.cost!!}")
                    ans = minOf(ans, tmp.cost!! + dfs(i+1))
                }
                i++
            }
            dp[ix] = ans
            return ans
        }

        val ans = dfs(0)
        return if (ans >= INF) -1 else ans
    }
}
