class Solution:
    def getWordsInLongestSubsequence(self, n: int, words: List[str], groups: List[int]) -> List[str]:

        dp = [(1,-1)]*n
        best = 0
        for i in range(1, n):
            for j in range(0,i):
                if groups[i] != groups[j]:
                    length = dp[j][0]+1
                    if length > dp[i][0]:
                        dp[i] = (length, j)
                        if dp[i][0] > dp[best][0]:
                            best = i

        ans = []
        while best != -1:
            ans.append(words[best])
            best = dp[best][1]
        return ans[::-1]
