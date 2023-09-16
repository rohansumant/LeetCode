# binary search + dfs
# Still TLE. Python just seems too slow for this problem

from queue import Queue, PriorityQueue

class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:

        dx = [1,-1,0,0]
        dy = [0,0,1,-1]
        
        r, c = len(grid), len(grid[0])
        
        def valid(x,y):
                return min([x,y]) >= 0 and x < r and y < c
        
        
        vis = [[False]*c for _ in range(r)]
        
        def dfs(x,y,limit,grid):
            if x == r-1 and y == c-1:
                return True
            vis[x][y] = True
            pathFound = False
            for i in range(4):
                nx, ny = x+dx[i], y+dy[i]
                if valid(nx,ny) and (not vis[nx][ny]) and grid[nx][ny] >= limit:
                    pathFound |= dfs(nx,ny,limit,grid)
            vis[x][y] = False
            return pathFound
        
                
        
        
        def paint(grid):
            
            Q = Queue()

            for i in range(r):
                for j in range(c):
                    if grid[i][j] == 1:
                        Q.put((i,j,0))
                                                
            grid = [[-1]*c for _ in range(r)]
            while not Q.empty():
                (x,y,cost) = Q.get()
                if grid[x][y] != -1:
                    continue
                grid[x][y] = cost
                for ii in range(4):
                    nx, ny = x+dx[ii], y+dy[ii] 
                    if valid(nx,ny) and grid[nx][ny] == -1:
                        Q.put((nx,ny,cost+1))
                        
            return grid
        
        grid = paint(grid)
        #print(grid)
        
        
        L, R = 0, r+c
        while L < R-1:
            m = (L+R)//2
            ok = (False if m > grid[0][0] else dfs(0,0,m,grid))
            if ok:
                L = m
            else:
                R = m
                
                
        ans = L
        return ans
