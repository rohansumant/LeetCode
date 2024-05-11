class Solution {
    fun minCostToEqualizeArray(nums: IntArray, _cost1: Int, _cost2: Int): Int {
        val cost1 = _cost1.toLong()
        val cost2 = minOf(_cost2.toLong(), 2*cost1)
        val MOD = 1000000007
        val n = nums.size
        if (n == 1) return 0
        if (n == 2) return ((1L * cost1 * abs(nums[0]-nums[1])) % MOD).toInt()
        val mn = nums.min()
        var total = 0L
        nums.forEach {
            total += it
        }
        fun calc(limit: Int): Long {
            val mx = 0L + limit - mn
            val diffTotal = 1L*limit*n - total
            val rest = diffTotal - mx
            var ans = 0L
            if (mx == rest) {
                ans = cost2 * mx
            } else if (mx > rest) {
                ans = cost2 * rest + (mx-rest) * cost1
            } else {
                val ops = diffTotal/2
                ans = ops * cost2 + (diffTotal % 2)*cost1
            }
            //println("$limit $diffTotal $mx $rest: $ans")
            return ans
        }

        var l = nums.max(); var r = 2*l+10;
        /*while (l < r-2) {
            val oneThird = (r-l)/3
            val ll = l + oneThird
            val rr = r - oneThird
            if (calc(ll) < calc(rr)) {
                r = rr
            } else {
                l = ll
            }
        }*/
        //println("range $l $r")
        val ans = (l..r).map{calc(it)}.min()
        return (ans % MOD).toInt()
    }
}
