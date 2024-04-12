class Solution {
    fun minimumCost(n: Int, edges: Array<IntArray>, query: Array<IntArray>): IntArray {
        val compress = HashMap<Pair<Int, Int>, Int>()
        for ((u,v,c) in edges) {
            var p = if (v < u ) Pair(v,u) else Pair(u,v)
            if (p !in compress) {
                compress.put(p, c)
            } else{
                val curr = compress.get(p)
                compress.put(p, curr!! and c)
            }
        }

        val G = Array(n) {
            mutableListOf<Pair<Int,Int>>()
        }
        for ((u,v) in compress.keys) {
            val c = compress.get(Pair(u,v))!!
            G[u] += Pair(v,c)
            G[v] += Pair(u,c)
        }
        var cmpNumber = 0
        val vis = BooleanArray(n) {false}
        val nodeToCmpMap = IntArray(n) {0}
        val cmpToAnsMap = HashMap<Int, Int>()

        var curr_ans : Int = Integer.MAX_VALUE

        fun dfs(x: Int, cmp: Int) {
            if (vis[x]) return
            vis[x] = true
            nodeToCmpMap[x] = cmp
            for ((ch, cost) in G[x]) {
                curr_ans = curr_ans and cost
                if (!vis[ch]) {
                    dfs(ch, cmp)
                }
            }
        }


        for (i in 0..n-1) if (!vis[i]) {
            curr_ans = Integer.MAX_VALUE
            dfs(i, ++cmpNumber)
            cmpToAnsMap[cmpNumber] = curr_ans
        }

        //println("${cmpToAnsMap}")

        val ansLs = mutableListOf<Int>()
        for ((u,v) in query) {
            curr_ans = -1
            if (nodeToCmpMap[u] == nodeToCmpMap[v]) {
                //println("$u, ${nodeToCmpMap[u]}")
                curr_ans = cmpToAnsMap[nodeToCmpMap[u]]!!
            }
            ansLs += curr_ans
        }
        return ansLs.toIntArray()
    }
}
