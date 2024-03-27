class Solution {
    fun minOperations(k: Int): Int {

        fun roundup(a: Int,b: Int): Int {
            val x = if (a % b == 0) 0 else 1
            return a/b + x
        }

        var steps = k-1
        for (i in 2 .. roundup(k,2)) {
            steps = minOf(steps, i-1 + roundup(k-i,i))
        }
        return if (steps == k) 0 else steps
    }
}
