class Solution {
    fun minimumCost(m: Int, n: Int, hc: IntArray, vc: IntArray): Long {
        val arr = IntArray(2) {1}
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy{-it.first})
        for (i in hc) {
            pq += i to 0
        }
        for (i in vc) {
            pq += i to 1
        }
        var ans = 0L
        while(!pq.isEmpty()) {
            val (cost, flag) = pq.remove()
            ans += cost * arr[flag xor 1]
            arr[flag]++
        }
        return ans
    }
}
