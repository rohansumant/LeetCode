# This should have been B. Way too easy for a D.
class Solution:
    def maxSpending(self, values: List[List[int]]) -> int:
        d = 1
        m, n = len(values), len(values[0])
        ans = 0
        for i in range(m*n):
            last = [(values[i][-1], i) for i in range(m) if len(values[i]) > 0]
            _, ix = min(last)
            ans += d * values[ix].pop()
            d += 1
        return ans
