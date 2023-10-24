'''
Cool problem; got stuck for a day. The complexity of this solution seems weird but adds up to O(N).
M = minimum count of repeated elements in nums
D = count of distinct elements in nums
Complexity = O(M*D) ~ O(N)
'''
class Solution:
    def minGroupsForValidAssignment(self, nums: List[int]) -> int:
        def ok(val, arr):
            for i in arr:
                q = i // val
                l = q*val
                r = q*(val+1)
                if not (l <= i <= r):
                    return False
            return True

        def count(val, arr):
            ans = 0
            for i in arr:
                ans += i // (val+1) + (1 if (i%(val+1)!=0) else 0)
            return ans

        arr = [v for v in Counter(nums).values()]
        for i in range(min(arr),0,-1):
            if ok(i, arr):
                print(i, arr)
                return count(i, arr)
        return -1
