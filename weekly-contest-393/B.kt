class Solution {
    fun maximumPrimeDifference(nums: IntArray): Int {
        var first: Int? = null
        var last: Int? = null

        // too late in the night to implement a sieve :(
        var primes = IntArray(101) {-1}
        fun isPrime(x: Int): Boolean {
            if (x < 2) return false
            if (primes[x] != -1) return primes[x] == 1
            primes[x] = 1
            var i = 2
            while (i*i <= x) {
                if (x % i == 0) {
                    primes[x] = 0
                    break
                }
                i++
            }
            return primes[x] == 1
        }

        nums.forEachIndexed {
            i,e ->
            if (isPrime(e)) {
                first = first ?: i
                last = i
            }
        }
        return last!! - first!!
    }
}
