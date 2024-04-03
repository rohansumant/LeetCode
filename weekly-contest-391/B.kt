class Solution {
    fun maxBottlesDrunk(numBottles: Int, numExchange: Int): Int {
        var full = numBottles
        var empty = 0
        var x = numExchange
        var ans = 0
        while (full > 0 || empty >= x) {
            if (empty >= x) {
                empty -= x
                full++
                x++
            } else {
                ans += full
                empty += full
                full = 0
            }
        }
        return ans
    }
}
