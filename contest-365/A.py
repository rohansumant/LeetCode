class Solution:
    def maximumTripletValue(self, nums: List[int]) -> int:
        n = len(nums)
        lmax = list(accumulate(nums, lambda x,y: max(x,y)))
        rmax = list(accumulate(nums[::-1], lambda x,y: max(x,y)))[::-1] # ugly but concise
        ans = 0
        #print(lmax, rmax)
        for i in range(1, n-1):
            if (lmax[i-1] > nums[i]):
                ans = max(ans, (lmax[i-1] - nums[i])*rmax[i+1])
        return ans
