class Solution {
    fun findLatestTime(s: String): String {
        fun ok(x: String): Boolean {
            val hrs = x.substring(0, 2).toInt()
            val mins = x.substring(3).toInt()
            return hrs < 12 && mins < 60
        }

        val ls = mutableListOf<Char>()
        fun dfs(ix: Int): Boolean {
            if (ix == 5) {
                return ok(ls.joinToString(separator=""))
            }
            if (s[ix] == '?') {
                var found = false
                for (i in 9 downTo 0) {
                    ls += '0'+i
                    found = dfs(ix + 1)
                    if (found) break
                    ls.removeLast()
                }
                return found
            } else {
                ls += s[ix]
                val found = dfs(ix+1)
                if (!found) {
                    ls.removeLast()
                }
                return found
            }
        }

        dfs(0)
        return ls.joinToString(separator="")
    }
}
