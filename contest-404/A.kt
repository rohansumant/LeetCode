class Solution {
    fun maxHeightOfTriangle(red: Int, blue: Int): Int {
        fun fn(r: Int, b: Int): Int {
            var red = r
            var blue = b
            var ans = 0
            var i = 1
            while(true) {
                //println("$blue $red $i")
                if (i%2 == 1) {
                    if (blue >= i) {
                        blue -= i
                        ans++
                    } else break
                } else {
                    if (red >= i) {
                        red -= i
                        ans++
                    } else break
                }
                i++
            }
            return ans
        }
        return max(fn(red, blue), fn(blue, red))
    }
}
