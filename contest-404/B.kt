class Solution {
    fun maximumLength(nums: IntArray): Int {
        val n = nums.size
        var z = 0
        var o = 0
        for (i in 0..<n) {
            nums[i] = nums[i]%2
            if (nums[i] == 0) z++
            else o++
        }
        var c1 = 0
        var c2 = 0
        var exp = 1
        for (i in 0..<n) {
            if (nums[i] == exp) {
                exp = exp xor 1
                c1++
            }
        }
        exp = 0
        for (i in 0..<n) {
            if (nums[i] == exp) {
                exp = exp xor 1
                c2++
            }
        }
        //println("${nums.toList()}")
        return maxOf(o,z,c1,c2)
    }
}
