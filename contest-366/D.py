class Solution:
    def maxSum(self, nums: List[int], k: int) -> int:
        '''
        11 5 4 9
        1 0 1 1
        0 1 0 1
        0 1 0 0
        1 0 0 1
        -------
        1 1 1 1
        1 1 0 1
        0 0 0 1
        -------
        15 13 1
        -------
        395
        '''
        c = Counter()
        for i in nums:
            for j in range(0, 32):
                bitSet = i & (1<<j) != 0
                if bitSet:
                    c[j] += 1
        print(c)
        arr = []
        for _ in range(k):
            num = 0
            for ix in range(31, -1, -1):
                if c[ix] > 0:
                    num |= (1<<ix)
                    c[ix] -= 1
            arr.append(num)
        print(arr)
        MOD = int(1e9 + 7)
        return sum(map(lambda x: x*x, arr)) % MOD
