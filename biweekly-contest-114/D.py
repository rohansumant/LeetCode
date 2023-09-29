class Solution:
    def maxKDivisibleComponents(self, n: int, edges: List[List[int]], values: List[int], k: int) -> int:

	G = [list() for _ in range(n)]
	for u,v in edges:
	    G[u].append(v)
	    G[v].append(u)

	modsum = [0]*n
	def dfs1(curr, par):
	    ans = values[curr] % k
	    for ch in G[curr]:
		if ch != par:
		    ans = (ans + dfs1(ch, curr)) % k
	    modsum[curr] = ans % k
	    return modsum[curr]

	dfs1(0,-1)
	#print(modsum)

	def dfs2(curr, par):
	    ans = 1 if modsum[curr] == 0 else 0
	    for ch in G[curr]:
		if ch != par:
		    ans += dfs2(ch, curr)
	    return ans

	return dfs2(0,-1)
