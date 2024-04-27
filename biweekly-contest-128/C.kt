typealias PII = Pair<Int, Int>
class Solution {
    fun minimumTime(n: Int, edges: Array<IntArray>, disappear: IntArray): IntArray {
        val INF = 1e9.toInt()
        val G = Array(n) {
            mutableListOf<PII>()
        }
        edges.forEach {
            (u,v,c) ->
            G[u] += v to c
            G[v] += u to c
        }

        val pq = PriorityQueue<PII>(object: Comparator<PII> {
            override fun compare(curr: PII, other: PII): Int {
                return compareValues(curr.second, other.second)
            }
        })

        val D = IntArray(n) {INF}

        pq  += (0 to 0)
        while (!pq.isEmpty()) {
            val (u, c) = pq.peek()
            pq.remove()
            if (D[u] != INF) continue
            D[u] = c
            if (D[u] >= disappear[u]) continue
            G[u].forEach {
                (v,cc) ->
                pq += (v to (c+cc))
            }
        }

        return D.zip(disappear).map {
            (u,v) ->
            if (u >= v) -1 else u
        }.toIntArray()
    }
}
