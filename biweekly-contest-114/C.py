import functools
class Solution:
	def maxSubarrays(self, nums: List[int]) -> int:
		score = functools.reduce(lambda x,y: x & y, nums)
		i, j = 0, 0
		n = len(nums)
		ans = 0
		#print(score)

		if score != 0:
			return 1

		while i < n:
			#print("I here",i)
			curr_score = nums[i]
			j = i+1
			while j < n and curr_score > score:
				curr_score &= nums[j]
				j += 1
			#print(i,curr_score,score)
			if curr_score == score:
				ans += 1
			i = j
		return ans
