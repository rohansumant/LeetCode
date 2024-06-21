class Solution {


    class SegmentTree(
        val nums: IntArray
    ) {
        var arr = IntArray(0)
        init {
            val size = nums.size
            arr = IntArray(4*size)
        }

        private fun isPeak(x: Int, y: Int, z: Int): Boolean {
            return y > x && y > z
        }

        fun build(ix: Int, l: Int, r: Int) {
            if (l == r) {
                if (l == 0 || l == nums.size-1) arr[ix] = 0
                else arr[ix] = if (isPeak(nums[l-1],nums[l],nums[l+1])) 1 else 0
                //println("$ix $l $r ${arr[ix]}")
                return
            }
            val m = l + (r-l)/2
            build(ix*2+1,l,m)
            build(ix*2+2,m+1,r)
            arr[ix] = arr[ix*2+1] + arr[ix*2+2]
            //println("$ix $l $r ${arr[ix]}")
        }

        fun get(ix: Int, l: Int, r: Int,
                ql: Int, qr: Int): Int {
            if (r < ql || qr < l) return 0
            if (ql <= l && r <= qr) {
                //println("$ix $l $r $ql $qr ${arr[ix]}")
                return arr[ix]
            }
            val m = l + (r-l)/2
            val ans = get(ix*2+1, l, m, ql, qr) +
                    get(ix*2+2, m+1, r, ql, qr)
            //println("$ix $l $r $ql $qr $ans")
            return ans

        }

        fun update(ix: Int, l: Int, r: Int,
                    qix: Int) {
            //println("$ix $l $r $qix")
            if (qix < l || qix > r) return
            if (l == r && l == qix) {
                //println("$ix $l $r $qix ${arr[ix]}")
                if (qix == 0 || qix == nums.size-1) arr[ix] = 0
                else arr[ix] = if (isPeak(nums[qix-1],nums[qix],nums[qix+1])) 1 else 0
                //println("$ix $l $r $qix ${arr[ix]}")
                return
            }
            val m = l + (r-l)/2
            update(ix*2+1,l,m,qix)
            update(ix*2+2,m+1,r,qix)
            arr[ix] = arr[ix*2+1] + arr[ix*2+2]
            //println("$ix $l $r $qix ${arr[ix]}")
        }
    }
    fun countOfPeaks(nums: IntArray, queries: Array<IntArray>): List<Int> {
        val n = nums.size
        val st = SegmentTree(nums)
        st.build(0, 0, n-1)

        val ls = mutableListOf<Int>()
        for (q in queries) {
            if (q[0] == 1) {
                val len = q[2]-q[1]+1
                if (len < 3) ls += 0
                else ls += st.get(0,0,n-1,q[1]+1,q[2]-1)
                //println("##")
            }
            else {
                val ix = q[1]
                val e = q[2]
                nums[ix] = e
                //println("${nums.toList()}")
                (ix-1 .. ix+1).forEach {
                    if (it >= 0 && it < n) st.update(0,0,n-1,it)
                }
            }
        }
        return ls
    }
}
