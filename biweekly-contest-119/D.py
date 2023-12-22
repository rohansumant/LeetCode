class Solution:
    def numberOfSets(self, n: int, maxDistance: int, roads: List[List[int]]) -> int:

        roads.sort(key = lambda x: x[2], reverse = True)
        G = {}
        for u,v,cost in roads:
            G[u,v] = G[v,u] = cost

        #print(G)
        def ok(a):

            N = len(a)
            if N <= 1:
                return True

            MAX = int(1e6)
            dp = [[MAX]*n for _ in range(n)]

            for i in a:
                for j in a:
                    if i == j:
                        dp[i][j] = 0
                    else:
                        dp[i][j] = dp[j][i] = G[i,j] if (i,j) in G else MAX

            # floyd warshall's
            for i in range(N):
                for j in range(N):
                    for k in range(N):
                        dp[a[i]][a[j]] = dp[a[j]][a[i]] = min(dp[a[i]][a[j]],
                                                               dp[a[i]][a[k]] + dp[a[k]][a[j]])
            ans = True
            for i in range(N):
                for j in range(i+1,N):
                    if dp[a[i]][a[j]] > maxDistance:
                        ans = False
            #print(a, dp, ans)
            return ans

        ans = 0
        for mask in range(1<<n):
            ls = []
            for j in range(n):
                if mask & (1<<j) != 0:
                    ls.append(j)
            if ok(ls):
                ans += 1

        return ans
