class Solution {
    fun countDays(days: Int, meetings: Array<IntArray>): Int {
        val n = meetings.size
        meetings.sortBy {it[0]}
        var end = 0
        var ans = 0
        meetings.forEach {
            (l, r) ->
            //println("$l $r")
            if (end < l) ans += l-end-1
            end = maxOf(end, r)
        }
        ans += days-end
        return ans
    }
}
