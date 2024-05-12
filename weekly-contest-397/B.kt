class Solution {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val INF = (2e8).toInt()
        val n = energy.size
        var ans = -INF
        for (i in 0..k-1) {
            var curr = 0
            for (j in n-1-i downTo 0 step k) {
                curr += energy[j]
                ans = maxOf(ans, curr)
            }
        }
        return ans
    }
}
