'''
Difficult upsolve.
Good resouce:
https://leetcode.com/problems/count-beautiful-substrings-ii/solutions/4330450/python3-prefix-sum/
'''
class Solution:
    def beautifulSubstrings(self, s: str, k: int) -> int:
        def gen_k_new():
            x = k
            i = 2
            k_new = 2
            while x != 1:
                pcnt = 0
                while x % i == 0:
                    x //= i
                    pcnt += 1
                k_new *= i ** (pcnt//2 + pcnt%2)
                i += 1
            return k_new

        k_new = gen_k_new()
        V = set([i for i in 'aeiou'])
        n = len(s)
        psum = [1 if ch in V else -1 for ch in s]
        psum = list(accumulate(psum))

        print(psum, k_new)
        c = Counter()
        c[0,-1 % k_new] = 1
        ans = 0
        for ix, p in enumerate(psum):
            ans += c[p, ix % k_new]
            c[p, ix % k_new] += 1
        return ans
