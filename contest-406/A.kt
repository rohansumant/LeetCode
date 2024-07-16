class Solution {
    fun getSmallestString(s: String): String {
        val arr = s.toCharArray()
        for (i in 1..<arr.size) {
            if ((arr[i].toInt() xor arr[i-1].toInt()) % 2 == 0 && arr[i] < arr[i-1]) {
                arr[i] = arr[i-1].also {
                    arr[i-1] = arr[i]
                }
                break
            }
        }
        return arr.joinToString("")
    }
}
