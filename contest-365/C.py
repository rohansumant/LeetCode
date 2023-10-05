class Solution:
    def minSizeSubarray(self, nums: List[int], target: int) -> int:
        n = len(nums)
        base_count = n * (target // sum(nums))
        target %= sum(nums)
        #aprint(sum(nums), target, base_count)
        if target == 0:
            return base_count
        nums = nums + nums
        d = {}
        d[0] = -1
        ans = int(1e9)
        running_sum = 0
        for i,v in enumerate(nums):
            running_sum += v
            
            diff = running_sum - target
            #print(i, v, running_sum, diff, diff in d)
            if diff in d:
                assert(d[diff] < i)
                ans = min(ans, i - d[diff])
            d[running_sum] = i
        if ans == int(1e9):
            return -1
        return base_count + ans
