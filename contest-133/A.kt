class Solution {
    fun minimumOperations(nums: IntArray): Int {
        return nums.fold(0, {a,e -> a + if (e%3 == 0) 0 else 1})
    }
}
