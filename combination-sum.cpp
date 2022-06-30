class Solution {
public:
    vector<vector<array<int,2>>> ans;
    
    void go(int ix,const vector<int> &c,vector<array<int,2>> &accum, int &target) {
        if (!target) {
            ans.push_back(accum);
            return;
        }
        if (target < 0 || ix == c.size()) return;
        const int el = c[ix];
        int cnt = target/el;
        for (int i=1;i<=cnt;i++) {
            accum.push_back({el,i});
            target -= el*i;
            go(ix+1,c,accum,target);
            target += el*i;
            accum.pop_back();
        }
        go(ix+1,c,accum,target);
    }
    
    void add(vector<int> &v,int el,int cnt) {
        while(cnt--) {
            v.push_back(el);
        }
    }
    
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<array<int,2>> accum;
        go(0,candidates,accum,target);
        vector<vector<int>> rv;
        for (auto &v : ans) {
            vector<int> tmp;
            for (auto [el,cnt] : v) {
                add(tmp,el,cnt);
            }
            rv.push_back(tmp);
        }
        return rv;
    }
};
