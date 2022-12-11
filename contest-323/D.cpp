class Solution {
public:
    vector<int> maxPoints(vector<vector<int>>& grid, vector<int>& queries) {
        int rows = grid.size(), cols = grid[0].size();
        
        int query_count = queries.size();
        vector<array<int,2>> Q(query_count);
        for (int i=0;i<query_count;i++) {
            Q[i] = {queries[i], i};
        }

        sort(Q.begin(),Q.end(),[](array<int,2> a, array<int,2> b) {
            return a[0] < b[0];
        });
        
        map<int,int> mp;
        vector<array<int,2>> frontier = {{0,0}};
        vector<vector<int>> vis(rows,vector<int>(cols));
        
        auto valid = [&](int x,int y) {
            return min(x,y) >= 0 and x < rows and y < cols;
        };
       
        int curr_explored = 0;
        auto expand = [&](int allowed) {
            queue<array<int,2>> Q;
            decltype(frontier) new_f;
            for (auto [x,y]: frontier) {
                if (grid[x][y] <= allowed) {
                    vis[x][y] = 0;
                    Q.push({x,y});
                } else {
                    new_f.push_back({x,y});
                }
            }
            
            while (!Q.empty()) {
                auto [x,y] = Q.front(); Q.pop();
                if (!valid(x,y) || vis[x][y]) continue;
                vis[x][y] = 1;
                // pos valid but not permitted in this iteration
                if (grid[x][y] > allowed) {
                    new_f.push_back({x,y});
                    continue;
                }
                curr_explored++;
                Q.push({x,y+1}); Q.push({x,y-1});
                Q.push({x+1,y}); Q.push({x-1,y});
            }
            
            frontier = new_f;
            
        };
        
        vector<int> ans(query_count);
        for (auto [val, ix] : Q) {
            expand(val-1);
            ans[ix] = curr_explored;
        }
        
        return ans;
    }
};
