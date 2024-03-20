class Solution {
    fun countSubstrings(s: String, c: Char): Long {
        val cnt = s.filter{it == c}.length
        return cnt*(cnt+1L)/2
    }
}
