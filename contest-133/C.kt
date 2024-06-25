class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var flip = 0
        var ans = 0
        for (i in 0..<n) {
            val e = nums[i]
            if (e xor flip == 0) {
                flip = flip xor 1
                ans++
            }
        }
        return ans
    }
}

