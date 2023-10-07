class Solution:
    def maximumSumOfHeights(self, maxHeights: List[int]) -> int:
        n = len(maxHeights)
        
        def jumpTo(arr):
            ans = [0]*n
            stack = [] # (element, index)
            for i,e in enumerate(arr):
                while stack and stack[-1][0] >= e:
                    stack.pop()
                jump_index = -1
                if stack:
                    jump_index = stack[-1][1]
                index_diff = i - jump_index
                ans[i] = ans[jump_index] + e*index_diff
                stack.append((e,i))
            return ans
            
        left_jump = jumpTo(maxHeights)
        right_jump = jumpTo(maxHeights[::-1])[::-1]
        
        ans = n
        for i, e in enumerate(maxHeights):
            ans = max(ans, left_jump[i]+right_jump[i]-e)
        return ans
