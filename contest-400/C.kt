class Solution {
    fun clearStars(s: String): String {
        val n = s.length
        val delete = mutableSetOf<Int>()
        val arr = Array(26) {
            mutableListOf<Int>()
        }

        s.forEachIndexed {
            i,e ->
            if (e != '*') {
                arr[e-'a'] += i
            } else {
                var found  = false
                delete += i
                for (i in 0..25) if (!arr[i].isEmpty()) {
                    delete += arr[i].last()
                    arr[i].removeLast()
                    found = true
                    break
                }
                require(found)
            }
        }

        val sb = StringBuilder()
        s.forEachIndexed {
            i,e ->
            if (i !in delete) sb.append(e)
        }
        return sb.toString()

    }
}
