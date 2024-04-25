class Solution {
    fun numberOfSpecialChars(word: String): Int {
        val n = word.length
        val first = IntArray(26){-1}
        val last = IntArray(26){n+1}
        word.forEachIndexed {
            i, e ->
            val low = e.isLowerCase()
            val ix = e - (if (low) 'a' else 'A')
            if (low) {
                last[ix] = i
            } else {
                if (first[ix] == -1) {
                    first[ix] = i
                }
            }
        }
        return (0..25).map{
            last[it] < first[it]
        }.filter{it}.size
    }
}
