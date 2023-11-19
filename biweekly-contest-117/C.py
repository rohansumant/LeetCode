'''
A bit too hard to be C. Idea is to keep track of the letters in which
the prefix ends and the corresponding count. Simulteneously a mask indicating
which letters  of "leet" have been seen thus far is maintained. "e" appears
twice; 1st is tracked once, 2nd is tracked multiple times.
l: 0001
e: 0010
e: 0100 # only if the first e has been encountered
t: 1000

"x" indicates any character other than l/e/t.
'''

class Solution:
    def stringCount(self, n: int) -> int:
        dp = []
        MOD = int(1e9+7)
        for i in range(n):
            if i == 0:
                dp.append(defaultdict(int, {1:1, 2: 1, 8:1, 0:23}));
                continue
            prev = dp[-1]

            curr = defaultdict(int,prev)

            # x
            for k in curr:
                v = curr[k]
                curr[k] = (v*23) % MOD

            # l
            for mask in prev:
                curr[mask | 1] = (curr[mask | 1] + prev[mask]) % MOD

            # e
            for mask in prev:
                if mask & 2 == 0:
                    curr[mask | 2] = (curr[mask | 2] + prev[mask]) % MOD
                else:
                    curr[mask | 4] = (curr[mask | 4] + prev[mask]) % MOD


            # t
            for mask in prev:
                curr[mask | 8] = (curr[mask | 8] + prev[mask]) % MOD

            dp.append(curr)
        #print(dp[-1])
        return dp[-1][15]
