class Solution {
    fun minOperations(nums: IntArray): Int {
        val n = nums.size
        var ans = 0
        for (i in 0..<n) {
            if (nums[i] == 0) {
                ans++
                for (j in 0..2) {
                    if (i+j >= n) {
                        return -1
                    }
                    nums[i+j] = nums[i+j] xor 1
                }
            }
            //println("${nums.toList()}")
        }
        return ans
    }
}
