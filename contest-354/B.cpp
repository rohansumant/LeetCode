class Solution {
public:
    int maximumBeauty(vector<int>& nums, int k) {
        map<int,int> count;
        int n = nums.size();
        for (int i: nums) {
            int l = i-k;  //+1
            int r = i+k+1; //-1
            count[l]++;
            count[r]--;
        }
        int ans = 0, running_sum = 0;
        for (auto [_,v]: count) {
            running_sum += v;
            ans = max(ans, running_sum);
        }
        return ans;
    }
};
