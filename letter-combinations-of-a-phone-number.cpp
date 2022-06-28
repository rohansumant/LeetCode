class Solution {
public:
    unordered_map<char,string> mp;
    
    void go(int ix,const string &digits,string &accum,vector<string> &ans) {
        if (ix == digits.size()) {
            ans.push_back(accum);
            return;
        }
        for (char ch : mp[digits[ix]]) {
            accum.push_back(ch);
            go(ix+1,digits,accum,ans);
            accum.pop_back();
        }
    }
    
    vector<string> letterCombinations(string digits) {
        mp = {
            {'2', "abc"},
            {'3', "def"},
            {'4', "ghi"},
            {'5', "jkl"},
            {'6', "mno"},
            {'7', "pqrs"},
            {'8', "tuv"},
            {'9', "wxyz"}
        };
        
        vector<string> ans;
        if (digits.empty()) return ans;
        string accum;
        go(0,digits,accum,ans);
        return ans;
    }
};
