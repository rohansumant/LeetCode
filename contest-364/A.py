class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        c = Counter(s)
        if c['1'] == 0:
            return s
        else:
            return '1'*(c['1']-1) + '0'*c['0'] + '1'
