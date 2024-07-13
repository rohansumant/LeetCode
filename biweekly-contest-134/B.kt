class Solution {
    fun maximumPoints(a: IntArray, b: Int): Long {
        if (b < a.min()) return 0L
        return (a.fold(0L, {a,e-> a+e}) - a.min()+b)/a.min()
    }
}
