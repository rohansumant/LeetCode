ass Solution {

    data class Trie(val arr: Array<Trie?>, var ansIx: Int) {

        fun add(wc: Array<String>, ix: Int) {
            val word = wc[ix]
            val wlen = word.length
            var curr = this
            for (i in wlen-1 downTo 0) {
                if (curr.ansIx == null) {
                    curr.ansIx = ix
                } else if (wlen < wc[curr.ansIx].length) {
                    curr.ansIx = ix
                }
                val wix = word[i]-'a'
                if (curr.arr[wix] == null) {
                    curr.arr[wix] = Trie(Array<Trie?>(26){null}, ix)
                }
                curr = curr.arr[wix]!!
            }
            if (wlen < wc[curr.ansIx].length) {
                curr.ansIx = ix
            }
        }

        fun get(word: String): Int {
            val wlen = word.length
            var curr = this
            for (i in wlen-1 downTo 0) {
                val wix = word[i]-'a'
                if (curr.arr[wix] != null) {
                    curr = curr.arr[wix]!!
                } else {
                    return curr.ansIx
                }
            }
            return curr.ansIx
        }
    }

    fun stringIndices(wordsContainer: Array<String>, wordsQuery: Array<String>): IntArray {
        val t = Trie(Array<Trie?>(26){null},0)
        val cn = wordsContainer.size
        for (i in 0..cn-1) {
            t.add(wordsContainer, i)
        }
        return wordsQuery.map{t.get(it)}.toIntArray()
    }
}
