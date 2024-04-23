typealias PII = Pair<Int,Int>
typealias PIL = Pair<Int,Long>
class Solution {

    fun findAnswer(n: Int, edges: Array<IntArray>): BooleanArray {
        val G = Array(n) {
            mutableListOf<PII>()
        }
        edges.forEach {
            (u,v,c) ->
            G[u] += v to c
            G[v] += u to c
        }

        val INF = 1e10.toLong()
        val D = LongArray(n) {INF}

        fun dijkstra() {
            val pq = PriorityQueue<PIL>(
                object: Comparator<PIL> {
                    override fun compare(p1: PIL, p2: PIL): Int {
                        return compareValues(p1.second, p2.second)
                    }
                }
            )
            pq += 0 to 0L // start at 0 with cost 0
            while (!pq.isEmpty()) {
                val (u,c) = pq.peek()
                //println("$u $c")
                pq.remove()
                if (D[u] != INF) continue
                D[u] = c
                G[u].forEach{
                    (v,cc) ->
                    if (D[v] == INF) {
                        pq += v to (c + cc)
                    }
                }
            }
        }

        dijkstra()
        //println("${D.toList()}")

        val accumSet = mutableSetOf<PII>()
        val vis = BooleanArray(n) { false }
        fun dfs(x: Int) {
            if (vis[x]) return
            vis[x] = true
            G[x].forEach {
                (ch,c) ->
                if (D[ch] == D[x]-c) {
                    accumSet += ch to x
                    //println("$ch $x")
                    dfs(ch)
                }
            }
        }
        dfs(n-1)

        return edges.map{
            (u,v,_) ->
            accumSet.contains(u to v) ||
            accumSet.contains(v to u)
        }.toBooleanArray()
    }
}
