class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        var ans = 1
        while (i < n-1) {
            var j = i+1
            if (nums[j] != nums[i]) {
                val cmp = compareValues(nums[i], nums[j])
                while(j < n-1 && cmp == compareValues(nums[j], nums[j+1])) {
                    j++
                }
                ans = maxOf(ans, j-i+1)
            }
            i = j
        }
        return ans
    }
}
