class Solution {
    fun valueAfterKSeconds(n: Int, k: Int): Int {
        var arr = IntArray(n){1}.toList()
        val MOD = (1e9+7).toInt()
        for (i in 1..k) {
            arr = arr.runningReduce{a,e -> (a+e) % MOD}
        }
        return arr.last()
    }
}
