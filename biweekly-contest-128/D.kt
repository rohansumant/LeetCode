class Solution {
    fun numberOfSubarrays(nums: IntArray): Long {
        val n = nums.size
        val ls = ArrayDeque<Pair<Int, Int>>() //(index, value)
        val hm = HashMap<Int, MutableList<Int>>()
        var ans = 0L

        fun fn(ix: Int, ls: MutableList<Int>) : Int {
            val bsIx = ls.binarySearch(ix)
            return ls.size - (-bsIx - 1)
        }

        nums.forEachIndexed {
            i, e ->
            while (!ls.isEmpty() && ls.last().second <= e) {
                ls.removeLast()
            }
            var biggerIx = -1
            if (!ls.isEmpty()) {
                biggerIx = ls.last().first
            }
            ls += Pair(i,e)

            if (e !in hm) {
                hm.put(e, mutableListOf<Int>())
            }
            val indexLs = hm.get(e)!!
            indexLs += i
            ans += fn(biggerIx, indexLs)
        }
        return ans
    }
}
