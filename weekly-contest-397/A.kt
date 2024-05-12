class Solution {
    fun findPermutationDifference(s: String, t: String): Int {
        return s.mapIndexed {
            ix, e ->
            abs(ix - t.indexOf(e))
        }.sum()
    }
}
