class Solution {
    fun maximumLengthSubstring(s: String): Int {
        val arr = IntArray(26){0}
        var i = 0; var j = 0;
        val n = s.length
        var ans = 0
        while (i < n) {
            while (j < n && arr[s[j]-'a'] < 2) {
                arr[s[j]-'a']++
                j++
            }
            ans = maxOf(ans,j-i)
            if (j == n) break
            while (i < j && arr[s[j]-'a'] == 2) {
                arr[s[i]-'a']--
                i++
            }
        }
        return ans
    }
}
