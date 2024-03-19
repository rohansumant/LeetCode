class Solution {
    fun unmarkedSumArray(nums: IntArray, queries: Array<IntArray>): LongArray {
        val ls = nums.mapIndexed{i,e -> Pair(e,i)}.sortedBy{it.first}
        var ix = 0
        var unmarkedSum = nums.fold(0L){a,e -> a+e}
        val marked = mutableSetOf<Int>()
        val ans = mutableListOf<Long>()
        for (q in queries) {
            if (q[0] !in marked) {
                marked.add(q[0])
                unmarkedSum -= nums[q[0]]
            }
            var cnt = q[1]
            while (ix < ls.size && cnt != 0) {
                if (ls[ix].second !in marked) {
                    marked.add(ls[ix].second)
                    unmarkedSum -= ls[ix].first
                    --cnt
                }
                ++ix
            }
            ans += unmarkedSum
        }
        return ans.toLongArray()
    }
}
