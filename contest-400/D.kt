class Solution {

    class SegmentTree(val x: Int,
    val lix: Int,
    val rix: Int) {
        var left: SegmentTree? = null
        var right: SegmentTree? = null

        companion object {
            fun build(arr: IntArray, l: Int, r: Int): SegmentTree {
                if (l == r) {
                    return SegmentTree(arr[l], l, r)
                }
                val m = l + (r-l)/2
                val left = build(arr, l, m)
                val right = build(arr, m+1, r)
                return SegmentTree(left.x and right.x, l, r).also {
                    it.left = left
                    it.right = right
                }
            }
        }


        fun get(ql: Int, qr: Int): Int {
            if (ql > qr || qr < lix || ql > rix) return Int.MAX_VALUE
            if (lix >= ql && rix <= qr) return x
            val lans = left!!.get(ql, qr)
            val rans = right!!.get(ql, qr)
            return lans and rans
        }
    }


    fun minimumDifference(nums: IntArray, k: Int): Int {
        val n = nums.size
        val INF = 2e9.toInt()
        var ans = INF

        val st = SegmentTree.build(nums, 0, n-1)

        val cache = mutableMapOf<Pair<Int,Int>, Int>()
        fun getAnd(l:Int, r: Int): Int {
            if (l to r !in cache) {
                cache[l to r] = st.get(l,r)
            }
            return cache[l to r]!!
        }

        fun searchBelow(start: Int): Int {
            var l = 0
            var r = n - start
            while (l+1 < r) {
                val m = l + (r-l)/2
                if (getAnd(start, start+m-1) > k) {
                    l = m
                } else {
                    r = m
                }
            }
            val ans = getAnd(start, start+r-1)
            //println("$start ${start+r-1} $ans")
            return ans
        }

        fun searchAbove(start: Int): Int {
            var l = 0
            var r = n - start
            while (l+1 < r) {
                val m = l + (r-l)/2
                if (getAnd(start, start+m-1) <= k) {
                    r = m
                } else {
                    l = m
                }
            }
            val ans = getAnd(start, start+l-1)
            //println("$start ${start+r-1} $ans")
            return ans
        }

        for (i in 0..<n) {
            ans = minOf(ans, abs(nums[i]-k))
            if (nums[i] > k) {
                //println("main: $i ${nums[i]} ${searchBelow(i)}")
                ans = minOf(ans, nums[i] - k , abs(k - searchBelow(i)), abs(k - searchAbove(i)))
            }
        }
        return ans
    }
}
