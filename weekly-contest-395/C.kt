class Solution {
    fun minEnd(n: Int, x: Int): Long {
        val need: Long = n-1L
        var i=0 // x
        var j=0 // need
        var num: Long = x.toLong()
        while (j < 30) {
            while (i < 30 && (x.toLong() and (1L shl i) != 0L)) i++
            val bit = if (need and (1L shl j) != 0L) 1 else 0
            if (bit == 1) {
                num = num or (1L shl i)
            }
            i++
            j++
        }
        return num
    }
}
