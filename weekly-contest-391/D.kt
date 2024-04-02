class Solution {

    inline fun process(ls: List<Pair<Int,Int>>, ix: Int): Int {
        val n = ls.size
        if (ls[0].first == ix) {
            return ls[n-1].second - ls[1].second
        } else if (ls[n-1].first == ix) {
            return ls[n-2].second - ls[0].second
        } else {
            return ls[n-1].second - ls[0].second
        }
    }

    fun minimumDistance(points: Array<IntArray>): Int {
        val sum = points.mapIndexed{i,e -> Pair(i,e[0] + e[1])}.sortedBy{it.second}
        val diff = points.mapIndexed{i,e -> Pair(i,e[0] - e[1])}.sortedBy{it.second}
        val n = sum.size
        var ans = maxOf(process(sum,-1), process(diff,-1))
        for (i in 0..n-1) {
            val curr = maxOf(process(sum,i), process(diff,i))
            ans = minOf(ans, curr)
        }
        return ans

    }
}
