class Solution:
    def getWordsInLongestSubsequence(self, n: int, words: List[str], groups: List[int]) -> List[str]:

        def hamming_distance(s1, s2):
            if len(s1) != len(s2):
                return -1
            return len([(a,b) for a,b in zip(s1,s2) if a != b])

        dp = [(1,-1)]*n
        best = 0
        for i in range(1, n):
            for j in range(0,i):
                if groups[i] != groups[j] and hamming_distance(words[i], words[j]) == 1:
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



