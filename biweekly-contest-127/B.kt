ass Solution {
    fun minimumLevels(possible: IntArray): Int {
        val ls = possible.map {
            if (it == 0) -1 else 1
        }

        val total = ls.sum()

        var d = 0
        for (i in 0..ls.size-2) {
            d += ls[i]
            val b = total - d
            if (d > b) {
                return i+1
            }
        }
        return -1
    }
}
