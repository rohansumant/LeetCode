ass Solution {

    val dp = Array<IntArray>(51) {
            IntArray(51) {-1}
        }
    val MOD : Long = (1e9+7).toLong()

    fun clean(n: Int) {
        for (i in 0..n) {
            for (j in 0..n) {
                dp[i][j] = -1
            }
        }
    }

    fun sumOfPowers(nums: IntArray, k: Int): Int {
        nums.sort()
        val n = nums.size
        var ans : Long = 0L
        val m = HashMap<Int,Int>()
        for (i in 0..n-1) {
            for (j in i+1..n-1) {
                val diff = nums[j] - nums[i]
                if (diff !in m) {
                    clean(n)
                    m[diff] = subSeqWithDiffK(0,nums,k,diff)
                }
            }
        }

        val ls = m.toList().sortedByDescending{it.first}
        //println(ls)
        var prevCnt = 0
        for (p in ls) {
            var cnt = (p.second - prevCnt)
            if (cnt < 0) {
                cnt += MOD.toInt()
            } else {
                cnt %= MOD.toInt()
            }
            ans = (ans + (1L * p.first * cnt)) % MOD
            prevCnt = p.second
        }
        return (ans % MOD).toInt()
    }

    /**
    Number of subsequences with minimum difference >= diff
    and length == k.

    Pre-requisite: nums is sorted
     */
    fun subSeqWithDiffK(
        ix: Int, nums: IntArray,
        k: Int, diff: Int): Int {
        val n = nums.size
        if (n-ix < k) return 0
        if (k == 1) return n-ix
        if (dp[ix][k] != -1) return dp[ix][k]
        var ans : Long = 0L + subSeqWithDiffK(ix+1,nums,k,diff)
        for (i in ix+1..n-1) {
            if (nums[i] - nums[ix] >= diff) {
                ans = (ans + subSeqWithDiffK(i,nums,k-1,diff)) % MOD
                break
            }
        }
        //println("$ix $k $ans $diff")
        dp[ix][k] = (ans % MOD).toInt()
        return dp[ix][k]
    }

}
