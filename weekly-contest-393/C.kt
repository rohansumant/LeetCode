class Solution {

    fun gcd(a: Long, b: Long): Long {
        return when (b) {
            0L -> a
            else -> gcd(b, a%b)
        }
    }

    fun findKthSmallest(coins: IntArray, k: Int): Long {
        val n = coins.size
        fun lessThanEquals(x: Long): Long {
            var mask = (1 shl n) - 1
            var ans = 0L
            while (mask > 0) {
                var bits = 0
                var prod = 1L
                for (i in 0..n-1) if (mask and (1 shl i)!= 0) {
                    if (prod > x) break
                    prod *= coins[i] / gcd(prod, 1L*coins[i])
                    bits++
                }
                val curr = x/prod
                ans += if (bits%2 == 1) curr else -curr
                mask--
            }
            return ans
        }


        /*
        for (i in 1..coins.max()) {
            println("$i ${lessThanEquals(1L*i)}")
        }*/

        var l = 0L; var r = 50000000000L
        while (l+1 < r) {
            val m = l + (r-l)/2
            val rank = lessThanEquals(m)
            if (rank >= k) {
                r = m
            } else {
                l = m
            }
        }
        return r
    }
}
