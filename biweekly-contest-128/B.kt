class Solution {
    fun minRectanglesToCoverPoints(points: Array<IntArray>, w: Int): Int {
        val ls = points.map {
            (u,v) -> u
        }.groupingBy{it}.eachCount().keys.toList().sorted()
        var ans = 0
        var i = 0
        //println("${ls}")
        while (i < ls.size) {
            var j = i
            while (j < ls.size && ls[j] <= ls[i]+w) j++
            ans++
            i = j
        }
        return ans
    }
}
