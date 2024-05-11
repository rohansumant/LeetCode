class Solution {
    fun minAnagramLength(s: String): Int {
        val n = s.length

        fun anagram(x: String, y: String): Boolean {
            if (x.length != y.length) return false
            return x.groupingBy{it}.eachCount() == y.groupingBy{it}.eachCount()
        }

        fun ok(x: Int): Boolean {
            val ref = s.substring(0, x)
            for (i in 0..n-1 step x) {
                //println("$ref, ${s.substring(i,i+x)}, ${anagram(ref, s.substring(i,i+x))}")
                if (!anagram(ref, s.substring(i,i+x))) return false
            }
            return true
        }

        var ans: Int? = null
        for (i in 1..n/2) {
            if (n%i == 0) {
                val result = ok(i)
                //println("$i $result")
                if (result) {
                    ans = i
                    break
                }
            }
        }

        return ans ?: n
    }
}
