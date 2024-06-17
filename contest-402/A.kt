class Solution {
    fun countCompleteDayPairs(hours: IntArray): Long {
        val n = hours.size
        val mp = mutableMapOf<Int, Int>()
        var ans = 0L
        hours.forEach {
            val rem = it % 24
            val remrem = (24-rem) % 24 // variable naming is difficult
            if (remrem in mp) ans += mp[remrem]!!
            mp[rem] = 1 + (mp[rem] ?: 0)
        }
        return ans
    }
}
