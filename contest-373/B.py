'''
This is actaully my failed attempt to solve D.
Since the problem constraint for B are more relaxed, this
solution does get an AC for B.

v = c = x
len = 2x
x^2 must be divisible by k
'''
from math import sqrt, ceil
class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        n = len(s)
        vowels = set([i for i in 'aeiou'])
        vc = [0]*n
        for i in range(n):
            vc[i] = (0 if i == 0 else vc[i-1]) + (1 if s[i] in vowels else 0)

        sq = [i for i in range(1, n//2 + 5) if (i*i) % k == 0]
        print(len(sq))

        ans = 0
        for i in range(n):
            for j in sq:
                slen = 2*j # substring length
                if slen > (i+1):
                    break
                pix = i - slen
                vcount = vc[i] - (0 if pix < 0 else vc[pix])
                if vcount == j:
                    ans += 1


        return ans

