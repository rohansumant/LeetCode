class Solution {
    fun minChanges(n: Int, k: Int): Int {
        if (n and k != k) return -1
        return (n xor k).toString(2).filter{it == '1'}.length
    }
}
