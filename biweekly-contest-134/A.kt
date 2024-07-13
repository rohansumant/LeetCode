class Solution {
    fun numberOfAlternatingGroups(colors: IntArray): Int {
        val k = 3
        val n = colors.size
        val ls = colors.toList() + colors.toList()
        var i = 0
        var ans = 0
        while (i < n) {
            var j = i+1
            while (j < ls.size && ls[j] != ls[j-1]) j++
            // println("$i $j")
            ans += minOf(n-i, maxOf(0, j-i-k+1))
            i = j
        }
        return minOf(ans, colors.size)
    }
}
