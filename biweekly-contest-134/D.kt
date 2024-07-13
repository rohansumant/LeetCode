class Solution {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val n = nums.size
        val dp = Array(n) {HashMap<Int,Long>()}

        fun calc(ix: Int, mask: Int): Long {
            if (ix == n || nums[ix] < k) return 0L
            val aa = nums[ix] and mask
            if (aa < k) return 0L
            if (mask in dp[ix]) return dp[ix][mask]!!
            var ans = 0L
            if (aa == k) ans = 1L + calc(ix+1, aa)
            else ans = calc(ix+1, aa)
            dp[ix][mask] = ans
            return ans
        }

        var ans = 0L
        for (i in 0 until n) {
            if (nums[i] >= k) {
                ans += calc(i, nums[i])
            }
        }

        return ans
    }
}
