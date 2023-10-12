class Solution:
    def minOperations(self, s1: str, s2: str, x: int) -> int:
        arr = [t[2] for t in zip(s1,s2,range(1000)) if t[0] != t[1]]
        if len(arr) % 2 == 1:
            return -1

        @cache
        def solve(l,r):
            if r < l:
                return 0
            #print(l,r)
            assert(r-l+1 >= 2)
            c1 = min(arr[r] - arr[r-1], x)
            c2 = min(arr[r] - arr[l], x)
            c3 = min(arr[l+1] - arr[l], x)
            # I don't fully understand why 'c3 + solve(l+2,r)' is needed.
            ans = min([c1 + solve(l,r-2), c2 + solve(l+1,r-1), c3 + solve(l+2,r)])
            return ans

        print(arr)
        return solve(0,len(arr)-1)
