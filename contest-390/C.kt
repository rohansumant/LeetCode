class Solution {
    fun mostFrequentIDs(nums: IntArray, freq: IntArray): LongArray {
        val m1 = HashMap<Int,Long>()
        val m2 = TreeMap<Long,Int>()
        val ans = mutableListOf<Long>()
        val n = nums.size

        fun update(e: Long, delta: Int) {
            val curr = m2.get(e) ?: 0
            if (curr + delta == 0) {
                m2.remove(e)
            } else {
                m2.put(e,curr + delta)
            }
        }

        fun getMax() : Long {
            return (if (m2.size > 0) m2.lastKey() else 0)
        }

        for (i in 0..n-1) {
            val e = nums[i]
            val fr = freq[i]
            val oldFr = m1.get(e) ?: 0
            val newFr = 0L + fr + oldFr
            m1.put(e, newFr)
            update(oldFr,-1)
            update(newFr,1)
            ans += getMax()
        }
        return ans.toLongArray()
    }
}
