class Solution:
    def fourSum(self, nums: List[int], target: int) -> List[List[int]]:
        nums.sort()
        n = len(nums)
        
        tpls = []
        for i in range(0,n):
            for j in range(i+1,n):
                tpls.append((i,j,nums[i]+nums[j]))
        
        d = {}
        d1 = {}
        ans = set([])
        for (x,y,z) in tpls:
            rem = target-z
            if rem in d:
                for (p,q) in d[rem]:
                    if ({x,y}.intersection({p,q})):
                        continue
                    ans.add(tuple(sorted([nums[p],nums[q],
                                          nums[x],nums[y]])))
            if z not in d:
                d[z] = []
                d1[z] = set([])
            if (nums[x],nums[y]) not in d1[z]:
                d1[z].add((nums[x],nums[y]))
                d[z].append((x,y))
        
        return [[p,q,r,s] for (p,q,r,s) in ans]
