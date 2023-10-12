class Solution:
    def lastVisitedIntegers(self, words: List[str]) -> List[int]:
        prev_cnt = 0
        ans, a = [], []
        for s in words:
            if s == "prev":
                prev_cnt += 1
                ans.append(-1 if prev_cnt > len(a) else a[-prev_cnt])
            else:
                prev_cnt = 0
                a.append(int(s))
        return ans
