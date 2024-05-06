class Solution {
    fun addedInteger(nums1: IntArray, nums2: IntArray): Int {
        val n = nums1.size
        val m = nums2.size
        nums1.sort(); nums2.sort();
        return nums2[0] - nums1[0]
    }
}

