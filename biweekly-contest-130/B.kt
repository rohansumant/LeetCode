class Solution {
    fun maxPointsInsideSquare(points: Array<IntArray>, s: String): Int {
        val n = points.size
        for (i in 0..n-1) {
            val (u, v) = points[i]
            points[i][0] = u.absoluteValue
            points[i][1] = v.absoluteValue
        }

        fun ok(x: Int): Boolean {
            val arr = IntArray(26)
            for (i in 0..n-1) {
                val (u, v) = points[i]
                val ch = s[i]
                if (u in (0..x) && v in (0..x)) arr[ch-'a']++
                if (arr[ch-'a'] > 1) return false
            }
            return true
        }

        var l = 0
        var r = (1e9).toInt() + 7
        while (l < r-1) {
            val m = l + (r-l)/2
            if (ok(m)) {
                l = m
            } else {
                r = m
            }
        }
        return points.filter {
            (u,v) ->
            u in (0..l) && v in (0..l)
        }.size
    }
}
