class Solution {
    fun minimumAddedInteger(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        val INF = 1e5.toInt()
        nums1.sort(); nums2.sort();
        var ans = INF
        for (i in 0..n-2) {
            for (j in i+1..n-1) {
                var delta = INF
                var ix = 0
                for (k in 0..n-1) if (k !in listOf(i,j)) {
                    val currDiff = -(nums1[k] - nums2[ix++])
                    if (delta == INF) {
                        delta = currDiff
                    } else if (currDiff != delta) {
                        delta = INF
                        break
                    }
                }
                if (delta != INF) {
                    ans = minOf(ans, delta)
                }
            }
        }
        return ans
    }
}
