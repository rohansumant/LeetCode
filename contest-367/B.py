# Laughably suboptimal; but works
class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        n = len(s)
        ans = default = '1'*(n+1)
        for length in range(k, n+1):
            for j in range(n-length+1):
                substr = s[j:j+length]
                #print(substr)
                if Counter(substr)['1'] == k:
                    #print(substr)
                    ans = min(ans, substr)
            if ans != default:
                break

        return '' if ans == default else ans
