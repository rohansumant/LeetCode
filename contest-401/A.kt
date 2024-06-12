class Solution {
    fun numberOfChild(n: Int, k: Int): Int {
        val period = n*2 - 2
        val ix = k % period
        return if (ix > n-1) n-1 - (ix - n+1) else ix
    }
}
