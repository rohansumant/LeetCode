ass Solution {
    fun minimizeStringValue(s: String): String {
        val m = HashMap<Char, Int>()
        for (ch in 'a'..'z') {
            m[ch] = 0
        }
        for (ch in s) {
            if (ch != '?') {
                m[ch] = 1 + (m[ch] ?: 0)
            }
        }
        val ls = mutableListOf<Char>()
        for (ch in s) {
            if (ch == '?') {
                val (key, value) = m.minBy { e -> e.value }
                m[key] = 1 + (m[key] ?: 0)
                ls += key
            }
        }
        ls.sortDescending()
        val sb = StringBuilder()
        for (ch in s) {
            if (ch == '?') {
                sb.append(ls.removeLast())
            } else {
                sb.append(ch)
            }
        }
        return sb.toString()

    }
}
