class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        require(capacity.sum() >= apple.sum())
        val apples = apple.sum()
        val ls = capacity.sortedDescending()
        val nls = ls.scan(0){accum,e -> accum+e}.drop(1).takeWhile{it < apples}
        return nls.size+1
    }
}
