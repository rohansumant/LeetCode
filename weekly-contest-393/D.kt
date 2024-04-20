class Solution {
    fun minimumValueSum(nums: IntArray, andValues: IntArray): Int {
        val n = nums.size
        val m = andValues.size

        val INF = 1e9.toLong()

        data class T(val a: Int, val b: Int, val c: Int)

        val hm = HashMap<T, Long>()

        fun dfs(ix: Int, aix: Int, mask: Int): Long {
            if (ix == n && aix == m) return 0L
            if (ix == n || aix == m) return INF
            val lookup = hm.get(T(ix, aix, mask))
            if (lookup != null) return lookup
            val newMask = (nums[ix] and mask)
            var ans = 0L
            if (newMask < andValues[aix]) {
                ans = INF
            } else if (newMask > andValues[aix]) {
                ans = dfs(ix+1, aix, newMask)
            } else {
                ans = minOf(dfs(ix+1, aix, newMask), nums[ix] + dfs(ix+1, aix+1, -1))
            }
            //println("$ans")
            hm.put(T(ix, aix, mask), ans)
            return ans
        }

        val ans = dfs(0, 0, -1)
        return if (ans >= INF) -1 else ans.toInt()
    }
}
