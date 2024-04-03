class Solution {
    fun nc2(x: Int): Long {
        return (x*(x-1L))/2L
    }
    fun countAlternatingSubarrays(nums: IntArray): Long {
        val n = nums.size
        var ans = 0L
        var i = 0
        while (i < n) {
            var j = i+1
            while (j < n && nums[j] != nums[j-1]) j++
            val len = j-i
            ans += nc2(len+1)
            i = j
        }
        return ans
    }
}
