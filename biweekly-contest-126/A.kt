class Solution {
    fun sumOfEncryptedInt(nums: IntArray): Int {
        fun encrypt(_x: Int): Int {
            var x = _x
            var len = 0
            var mx = 0
            var cnt = 0
            while (x != 0) {
                mx = maxOf(x%10, mx)
                 x /= 10
                ++cnt
            }
            var accum = 0
            while(cnt-- != 0) {
                accum = accum*10 + mx
            }
            return accum
        }
        return nums.fold(0) {
            a,e -> a + encrypt(e)
        }
    }
}
