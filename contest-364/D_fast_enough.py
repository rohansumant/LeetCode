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



	def paint(curr, par):
	    vis = set()
	    def dfs(curr, par):
		vis.add(curr)
		curr_size = 1
		for ch in G[curr]:
		    if ch != par and ch not in primes:
			curr_size += dfs(ch, curr)
		return curr_size
	    dfs(curr, par)
	    for nd in vis:
		size[nd] = len(vis)

	ans = 0
	size = [0]*(n+1)
	for p in primes:
	    cc = [] # composite children
	    for ch in G[p]:
		if ch not in primes:
		    if size[ch] == 0:
			paint(ch, -1)
		    cc.append(size[ch])
	    #print(p, cc)
	    sum1 = base = sum(cc)
	    sum2 = 0
	    for v in cc:
		base -= v 
		sum2 += v * base
	    assert(base == 0)
	    #print(p, sum1, sum2)
	    ans += sum1 + sum2

	#print(size)
	return ans
