
class Solution {
    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val mp = mutableMapOf<Int, Long>()
        nums1.filter{it%k == 0}.forEach {
            mp[it/k] = 1L + (mp[it/k] ?: 0L)
        }

        //println("${mp}")
        if (mp.isEmpty()) return 0
        val mx = mp.maxBy{it.key}.key

        var ans = 0L
        nums2.toList()
            .groupingBy {it}
            .eachCount().forEach {
            (e, cnt) ->
                for (i in e..mx step e) {
                    if (i in mp) {
                        ans += 1L * mp[i]!! * cnt
                    }
                }
            }

        return ans
    }
}
