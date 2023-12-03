'''
Horrible technique but we get the W
'''
class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        n = len(nums)
        a = list(zip(nums,range(n)))
        ans = [0]*n
        a.sort()
        i = 0
        while i < n:
            prev = i
            j = i
            ls = []
            while j < n and abs(a[j][0] - a[prev][0]) <= limit:
                ls.append(a[j])
                prev = j
                j += 1
            vals = [pr[0] for pr in ls] # already sorted
            ixs = [pr[1] for pr in ls]
            #print(ls, vals, ixs)
            ixs.sort()
            for v,ix in zip(vals,ixs):
                ans[ix] = v
            i = j
        return ans

