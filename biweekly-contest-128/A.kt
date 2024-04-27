class Solution {
    fun scoreOfString(s: String): Int {
        return s.zip(s.substring(1)).map {
            (u,v) -> abs(u.toByte() - v.toByte())
        }.sum()
    }
}
