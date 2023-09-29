class Solution:
    def minOperations(self, nums: List[int]) -> int:
	c = Counter(nums)
	ans = 0
	for k in c:
	    if c[k] == 1:
		return -1
	    if c[k] % 3 == 0:
		ans += c[k] // 3
	    else:
		ans += c[k] // 3 + 1
	return ans
