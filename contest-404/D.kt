class Solution {

    fun diameter(edges: Array<IntArray>): Int {
        val n = edges.size + 1
        if (n <= 2) return n-1
        val G = Array(n) {
            mutableListOf<Int>()
        }
        for ((u,v) in edges) {
            G[u] += v
            G[v] += u
        }
        val sz = IntArray(n)
        val lp = IntArray(n) // longest path
        fun dfs(u: Int, p: Int): Int {
            sz[u] = 1
            for (ch in G[u]) if (ch != p) {
                sz[u] += dfs(ch, u)
            }
            return sz[u]
        }



        fun centroid(u: Int, p: Int): Int {
            for (ch in G[u]) if (ch != p) {
                if (sz[ch] > n/2) return centroid(ch, u)
            }
            return u
        }

        fun longestPath(u: Int, p: Int): Int {
            for (ch in G[u]) if (ch != p) {
                lp[u] = maxOf(lp[u], 1 + longestPath(ch, u))
            }
            return lp[u]
        }

        dfs(0, -1) // calculate size
        check(sz[0] == n)
        val c = centroid(0, -1) // identify centroid
        longestPath(c, -1)
        var mx = -1; var mx1 = -1;
        for (ch in G[c]) {
            if (lp[ch] > mx) {
                mx1 = mx
                mx = lp[ch]
            } else if (lp[ch] > mx1) {
                mx1 = lp[ch]
            }
        }
        check(listOf(mx, mx1).all{it >= 0})
        return 2 + mx1 + mx
    }

    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        val d1 = diameter(edges1)
        val d2 = diameter(edges2)
        // println("$d1 $d2")
        return maxOf(d1,d2,(d1+1)/2 + 1 + (d2+1)/2)
    }
}
