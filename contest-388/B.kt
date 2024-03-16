class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val ls = happiness.sortedDescending().take(k)
        var dec = 0
        var ans = 0L
        for (i in ls) {
            ans += i - minOf(dec,i)
            dec += 1
        }
        return ans
    }
}
