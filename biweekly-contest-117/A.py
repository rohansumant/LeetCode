# B harder than D :|
class Solution:
    def distributeCandies(self, n: int, limit: int) -> int:
        ans = 0
        for i in range(min(n,limit)+1):
            rem = n - i
            if rem <= limit*2:
                hf_rem = rem // 2
                ohf_rem = rem - hf_rem
                ways = min(hf_rem, limit - ohf_rem) + 1
                #print(i, rem, hf_rem, ways)
                ways = 2*ways - (1 if hf_rem == ohf_rem else 0)
                ans += ways
        return ans
                
