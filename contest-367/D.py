class Solution:
    def constructProductMatrix(self, grid: List[List[int]]) -> List[List[int]]:
        def flatten(matrix):
            return [item for row in matrix for item in row]

        N, M = len(grid), len(grid[0])
        print(N,M)

        arr = flatten(grid)

        prefix = list(accumulate(arr, lambda x,y: (x*y)%12345))
        suffix = list(accumulate(arr[::-1], lambda x,y: (x*y)%12345))[::-1]

        ans = arr[:]
        n = len(arr)
        for i in range(n):
            left = 1 if i == 0 else prefix[i-1]
            right = 1 if i == n-1 else suffix[i+1]
            ans[i] = (left*right) % 12345

        print(ans)
        result = []
        for ix in range(0,N*M,M):
            result.append(ans[ix:ix + M])
        #assert(len(result) == N)
        return result
