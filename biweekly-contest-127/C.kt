class Solution {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        if (k == 0) return 1
        val n = nums.size
        var j = 0
        val arr = IntArray(31){0}
        var ans = n+1
        for (i in 0..n-1) {
            while (j < n && getCurr(arr) < k) {
                update(arr, nums[j++], 1)
            }
            if(getCurr(arr) >= k) ans = minOf(ans, j-i)
            update(arr, nums[i], -1)
        }
        return if (ans == n+1) -1 else ans
    }

    inline fun getCurr(arr: IntArray) : Int {
        var ans = 0
        for (i in 30 downTo 0) {
            ans = (ans shl 1) + minOf(arr[i],1)
        }
        return ans
    }

    inline fun update(arr: IntArray, x: Int, delta: Int) {
        for (i in 0..30) {
            if ((x and (1 shl i)) != 0) {
                arr[i] += delta
                require(arr[i] >= 0)
            }
        }
    }
}
