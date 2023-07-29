class Solution:
    def longestValidSubstring(self, word: str, forbidden: List[str]) -> int:
        s = set([i[::-1] for i in forbidden])
        n = len(word)
        
        i, ans = 0, 0
        
        while i < n:
            j = i
            found = -1
            while j < n:
                suff = []
                for k in range(j, max(j-10,i-1), -1):
                    suff.append(word[k])
                    #print(suff)
                    if ''.join(suff) in s:
                        found = k
                        #print('found = k', found)
                        break
                if found == -1:
                    j += 1
                else:
                    ans = max(ans, j-i)
                    break
            if found == -1:
                assert(j == n)
                ans = max(ans, n-i)
                break
            else:
                i = found+1
                    
        #print(s)
        return ans
