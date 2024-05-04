class Solution {

    fun subarrayCount(l: Int): Long {
        return (l*(l+1L))/2
    }

    fun medianOfUniquenessArray(nums: IntArray): Int {
        val n = nums.size
        // function to determine number of subarrays with uniq cnt <= k
        fun fn(k: Int): Long {
            val uniq = mutableMapOf<Int,Int>()
            var i = 0; var outer = 0;
            var ans = 0L
            while (outer < n) {
                while (i < n && uniq.size < k) {
                    uniq[nums[i]] = 1 + (uniq[nums[i]] ?: 0)
                    i++
                }
                while (i < n && nums[i] in uniq) {
                    uniq[nums[i]] = uniq[nums[i]]!! + 1
                    i++
                }

                ans += (i-outer)
                uniq[nums[outer]] = uniq[nums[outer]]!! - 1
                if (uniq[nums[outer]] == 0) uniq.remove(nums[outer])
                outer++
            }
            return ans
        }


        val totalUniq = nums.toList().groupingBy{it}.eachCount().size
        var l = 0; var r = totalUniq;
        val cnt = subarrayCount(n)
        val target = if (cnt%2 == 0L) cnt/2-1 else cnt/2
        //println("$n $cnt $target")
        while (l+1 < r) {
            val m = (l+r)/2
            val x = fn(m)
            //println("$l $m $r: $x")
            if (x-1 < target) l = m
            else r = m
        }
        return r
    }
}
