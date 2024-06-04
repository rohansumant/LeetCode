class Solution {
    fun minimumChairs(s: String): Int {
        var runningSum = 0
        var ans = 0
        s.forEach {
            runningSum += if (it == 'E') 1 else -1
            require(runningSum >= 0)
            ans = maxOf(ans, runningSum)
        }
        return ans
    }
}
