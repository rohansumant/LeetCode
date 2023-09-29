class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        s = set(range(1,k+1))
        ans = 0
        while len(nums) > 0 and len(s) > 0:
            x = nums.pop()
            if x in s:
                s.remove(x)
            ans += 1
        return ans
