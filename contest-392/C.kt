class Solution {
    fun minOperationsToMakeMedianK(nums: IntArray, k: Int): Long {
        nums.sort()
        val n = nums.size
        val medianIx = n/2
        var ans = 0L
        var i = medianIx
        while (i >= 0 && nums[i] > k) {
            ans += nums[i] - k
            i--
        }
        i = medianIx
        while (i < n && nums[i] < k) {
            ans += k - nums[i]
            i++
        }
        return ans
    }
}
