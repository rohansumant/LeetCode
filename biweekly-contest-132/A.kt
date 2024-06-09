class Solution {
    fun clearDigits(s: String): String {
        val n = s.length
        val st = ArrayDeque<Char>()
        for (i in s) {
            if (st.isEmpty() && i.isLetter()) {
                st.addLast(i)
                continue
            }
            if (i.isLetter()) {
                st.addLast(i)
            } else {
                st.removeLast()
            }
        }
        return st.joinToString("")
    }
}
