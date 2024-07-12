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

        val pq = PriorityQueue<Pair<Int, Int>>(compareBy {it.second})
        pq += 0 to 0
        var ans = -1
        while (!pq.isEmpty()) {
            val (ix, cost) = pq.remove()
            if (ix == n) {
                ans = cost
                break
            }
            var i = ix
            var tmp = tr
            while (i < n) {
                val cix = target[i] - 'a'
                if (tmp.arr[cix] == null) break
                tmp = tmp.arr[cix]!!
                if (tmp.cost != null) {
                    // matching word found
                    pq.add(i+1 to cost+tmp.cost!!)
                }
                i++
            }
        }

        return ans

    }
}
