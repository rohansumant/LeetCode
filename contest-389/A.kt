class Solution {
    fun isSubstringPresent(s: String): Boolean {
        val m = mutableMapOf<String,Int>()
        for (i in 0..s.length-2) {
            val k = s.substring(i,i+2)
            val kr = k.reversed()
            m[k] = 1 + (m[k] ?: 0)
            m[kr] = 1 + (m[kr] ?: 0)
        }
        return m.values.filter{it>=2}.size > 0
    }
}
