class Solution {
    fun sumOfTheDigitsOfHarshadNumber(_x: Int): Int {
        var ans = 0
        var x = _x
        while (x > 0) {
            ans += x % 10
            x /= 10
        }
        return if (_x % ans == 0) ans else -1
    }
}
