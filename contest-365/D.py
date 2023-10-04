class Solution:
    def countVisitedNodes(self, edges: List[int]) -> List[int]:
        n = len(edges)
        G = [-1]*n # each node can have at most one child
        for u,v in enumerate(edges):
            G[u] = v
        
        #print(G)
        stack = [0]*n
        ans = [None]*n
        def dfs(curr, time):
            if G[curr] == -1:
                # no children
                ans[curr] = (1, -1)
                return ans[curr]
            if stack[curr] != 0:
                # cycle!
                return (time - stack[curr], curr)
            stack[curr] = time
            child = G[curr]
            child_ans = (ans[child][0],-1) if ans[child] else dfs(G[curr], time+1)
            if child_ans[1] != -1:
                curr_ans = child_ans[0]
            else:
                curr_ans = child_ans[0]+1
            stack[curr] = 0
            ans[curr] = (curr_ans, -1 if curr == child_ans[1] else child_ans[1])
            return ans[curr]
        
        for i in range(n):
            if not ans[i]:
                ans[i] = dfs(i, 1)
        
        return [p[0] for p in ans]
