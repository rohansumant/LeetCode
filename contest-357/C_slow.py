# Idea from https://leetcode.com/problems/find-the-safest-path-in-a-grid/solutions/3870053/bfs-dijkstra/
#


from queue import Queue, PriorityQueue

class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:

        dx = [1,-1,0,0]
        dy = [0,0,1,-1]
            
        def valid(x,y,r,c):
                return min([x,y]) >= 0 and x < r and y < c
        
        def dijkstra(grid):
            row, col = len(grid), len(grid[0])
            pq = PriorityQueue()
            pq.put((-grid[0][0],0,0)) # largest first
            dist = [[-1]*col for _ in range(row)]
            while not pq.empty():
                (cost,x,y) = pq.get()
                if valid(x,y,row,col) and dist[x][y] == -1:
                    dist[x][y] = min(-cost,grid[x][y])
                    
                    for ii in range(4):
                        nx, ny = x+dx[ii], y+dy[ii] 
                        if valid(nx,ny,row,col) and dist[nx][ny] == -1:
                            pq.put((-dist[x][y],nx,ny))
            #print(dist)
            return dist[row-1][col-1]
                
        
        
        def paint(grid):
            r, c = len(grid), len(grid[0])
            Q = Queue()

            for i in range(r):
                for j in range(c):
                    if grid[i][j] == 1:
                        Q.put((i,j,0))
                        
            #print(Q.qsize())
                        
            grid = [[-1]*c for _ in range(r)]
            while not Q.empty():
                (x,y,cost) = Q.get()
                if valid(x,y,r,c) and grid[x][y] == -1:
                    grid[x][y] = cost
                    for ii in range(4):
                        nx, ny = x+dx[ii], y+dy[ii] 
                        if valid(nx,ny,r,c) and grid[nx][ny] == -1:
                            Q.put((nx,ny,cost+1))
                        
            return grid
        
        grid = paint(grid)
        #print(grid)
        ans = dijkstra(grid)
        
        return ans
