class Solution:
    def differenceOfSums(self, n: int, m: int) -> int:
        def sum_all(x):
            return x*(x+1) // 2
        
        def arith_sum(d, cnt):
            return cnt*(2*d + (cnt-1)*d) // 2
        
        all = sum_all(n)
        cnt = n // m
        div_sum = arith_sum(m, cnt)
        
        non_div_sum = all - div_sum
        #print(all, div_sum, non_div_sum)
        return non_div_sum - div_sum
        
