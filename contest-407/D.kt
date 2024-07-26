class Solution {

    inline fun process(arr: IntArray, st: Int, ed: Int): Long {
        // println("$st $ed")
        var ans = 0L
        var prev = 0
        for (i in st..ed) {
            if (arr[i].absoluteValue >= prev) {
                ans += arr[i].absoluteValue - prev
            }
            prev = arr[i].absoluteValue
        }
        return ans
    }

    fun minimumOperations(nums: IntArray, target: IntArray): Long {
        val n = nums.size
        val arr = IntArray(n)
        for (i in 0..<n) {
            arr[i] = nums[i]-target[i]
        }

        var i = 0
        var ans = 0L
        while (i < n) {
            var j = i
            while (j < n && arr[j] >= 0) j++
            ans += process(arr, i, j-1)
            i = j
            while (j < n && arr[j] < 0) j++
            ans += process(arr, i, j-1)
            i = j
        }

        return ans
    }
}
