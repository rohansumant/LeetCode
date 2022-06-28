class Solution:
    def find(self,nums,x):
        n = len(nums)
        if x > nums[-1]:
            return -1
        l, r = -1, n-1
        while l < r-1:
            m = (l+r)//2
            if nums[m] < x:
                l = m
            else:
                r = m
        return r
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        if n == 0 or (target < nums[0]) or (target > nums[-1]):
            return [-1,-1]
        ix = self.find(nums,target)
        if nums[ix] != target:
            return [-1,-1]
        nix = self.find(nums,target+1)
        if nix == -1:
            return [ix,n-1]
        else:
            return [ix,nix-1]
