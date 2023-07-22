class Solution:
    def minimumIndex(self, nums: List[int]) -> int:
        n = len(nums)
        total, running_sum = {}, {}
        for i in nums:
            if i not in total:
                total[i] = 1
            else:
                total[i] += 1
            
        for i in range(n):
            e = nums[i]
            if e not in running_sum:
                running_sum[e] = 1
            else:
                running_sum[e] += 1
            cnt = running_sum[e]
            
            l = i+1
            r = n-l
            if cnt*2 > l and (total[e]-cnt)*2 > r:
                return i
        return -1
