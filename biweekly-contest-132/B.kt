class Solution {
    fun findWinningPlayer(skills: IntArray, k: Int): Int {
        val n = skills.size
        if (k >= n) return skills.indexOf(skills.max())
        val dq = ArrayDeque<Int>()
        for (i in skills) dq.addLast(i)
        var winStreak = 0
        var prevWinner = -1
        while (winStreak < k) {
            val x = dq.removeFirst()
            val y = dq.removeFirst()
            var winner = y
            if (x > y) winner = x
            if (winner == x) {
                dq.addFirst(x)
                dq.addLast(y)
            } else {
                dq.addFirst(y)
                dq.addLast(x)
            }
            if (winner == prevWinner) {
                winStreak++
            } else {
                winStreak = 1
            }
            prevWinner = winner
        }
        return skills.indexOf(prevWinner)
    }
}
