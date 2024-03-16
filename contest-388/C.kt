class Solution {
    fun uniqSubstrings(a: String) : List<String> {
        val sset = mutableSetOf<String>()
        for (len in 1..a.length) {
            for (i in 0..(a.length-len)) {
                sset += a.substring(i, i+len)
            }
        }
        return sset.toList().sortedWith(compareBy({it.length}, {it}))
    }
    fun check(ls : List<String>, all: MutableMap<String, Int>) : String {
        for (i in ls) {
            require(i in all)
            if (all[i] == 1) {
                return i
            }
        }
        return ""
    }
    fun shortestSubstrings(arr: Array<String>): Array<String> {
        val all = mutableMapOf<String, Int>()
        val subs = arr.map {uniqSubstrings(it)}
        for (ls in subs) {
            for (item in ls) {
                all[item] = 1 + ((if (item in all) all[item] else 0) as Int)
            }
        }
        val ans = subs.map {check(it, all)}
        println(ans)
        return ans.toTypedArray()
    }
}
