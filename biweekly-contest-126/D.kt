class Solution {
    fun sumOfPower(nums: IntArray, k: Int): Int {
        val MOD = 1e9.toLong() + 7L
        val n = nums.size
        val pow2 = (1..n).scan(1L){a,_ -> (2L*a) % MOD}
        val dp = Array(k+1) { LongArray(n+1) {0} }
        data class T(val a: Int,
                    val b: Int,
                    val c: Long)
        dp[0][0] = 1L
        for (num in nums) {
            val ls = mutableListOf<T>()
            for (prev in 0..k-1) {
                for (len in 0..n-1) {
                    val prev_subseq_cnt = dp[prev][len] % MOD
                    val new = prev + num
                    if (new <= k) {
                        //dp[new][len+1] = (dp[new][len+1] + prev_subseq_cnt) % MOD
                        ls += T(new, len+1, prev_subseq_cnt)
                        //println("$num $new $prev ${len+1} ${dp[new][len+1]}")
                    }
                }
            }
            for (it in ls) {
                val (a,b,c) = it
                require (a <= k)
                require (b <= n)
                dp[a][b] = (dp[a][b] + c) % MOD
            }
        }
        /*for (i in 0..k) {
            for (j in 0..n) {
                print("${dp[i][j]} ")
            }
            println("")
        }*/
        var ans = 0L
        for (len in 0..n) {
            if (dp[k][len] != 0L) {
                val cnt = dp[k][len]
                val rem = n - len
                //println("$k, $len, ${dp[k][len]}")
                ans = (ans + ((pow2[rem] * cnt) % MOD)) % MOD
            }
        }
        return ans.toInt()
    }
}
