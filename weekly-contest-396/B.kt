class Solution {
    fun minimumOperationsToMakeKPeriodic(word: String, k: Int): Int {
        val n = word.length
        val mp = mutableMapOf<String, Int>()
        var cnt = 0
        for (i in 0..n-1 step k) {
            val ss = word.substring(i, i+k)
            mp[ss] = (mp[ss] ?: 0) + 1
            cnt++
        }
        return cnt - mp.values.toList().max()
    }
}
