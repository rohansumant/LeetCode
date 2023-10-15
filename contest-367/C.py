class Solution:
    def findIndices(self, nums: List[int], indexDifference: int, valueDifference: int) -> List[int]:

        n = len(nums)
        prefix_max = list(accumulate(nums, max))
        prefix_min = list(accumulate(nums, min))

        found = -1
        for i in range(indexDifference, n):
            op1 = prefix_max[i - indexDifference]
            op2 = prefix_min[i - indexDifference]
            if (abs(op1 - nums[i]) >= valueDifference or
                abs(op2 - nums[i]) >= valueDifference):
                found = i
                break

        ans = [-1, -1]
        if found == -1:
            return ans

        ans[1] = found
        for i in range(found-indexDifference+1):
            e = nums[i]
            if abs(e-nums[found]) >= valueDifference:
                ans[0] = i

        assert(ans[0] != -1)
        return ans
