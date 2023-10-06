class Solution:
    def countPaths(self, n: int, edges: List[List[int]]) -> int:
        def sieve(n):
            arr = [True]*n
            arr[0] = arr[1] = False
            for i in range(2,n):
                if arr[i]:
                    for j in range(i+i,n,i):
                        arr[j] = False
            return arr
        
        primes = set([p[1] for p in zip(sieve(n+1),range(n+1)) if p[0]])
        G = [list() for _ in range(n+1)]
        for u,v in edges:
            G[u].append(v)
            G[v].append(u)
        
        def nc2(x):
            return (x*(x-1)) // 2
        
        def dfs(curr, par):
            curr_size = 1
            children_paths = 0
            for ch in G[curr]:
                if ch != par and ch not in primes:
                    child_size = dfs(ch, curr)
                    curr_size += child_size
                    children_paths += nc2(child_size)
            if curr in primes:
                # back to root
                return nc2(curr_size) - children_paths
            else:
                return curr_size
        
        ans = 0
        #print(primes)
        for p in primes:
            ans += dfs(p, -1)
        return ans
