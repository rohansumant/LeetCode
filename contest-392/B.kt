class Solution {
    fun getSmallestString(s: String, k: Int): String {
        val sb = StringBuilder()
        var cnt = k
        s.forEach {
            val d2a = minOf(it-'a', ('a'-it+26))
            if (d2a <= cnt) {
                sb.append('a')
                cnt -= d2a
            } else {
                //require(it-cnt > 'a')
                sb.append(it-cnt)
                cnt = 0
            }
        }
        return sb.toString()
    }
}
