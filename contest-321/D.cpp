class Solution {
public:
    int countSubarrays(vector<int>& nums, int k) {
        int n = nums.size();
        int found = -1, sum = 0;
        unordered_map<int,int> mp;
        int ans = 0;
        for (int i=0;i<n;i++) {
            int el = nums[i];
            sum += (el <= k) ? -1:1;
            if (el == k) found = i;
            if (found == -1) {
                mp[sum]++;
            } else {
                // if (el == k) mp[sum]++; // exception for k
                if (mp.count(sum)) ans += mp[sum];
                if (mp.count(sum+1)) ans += mp[sum+1];
                 if (!sum || sum == -1) ans++;
            }
        }
        return ans;
    }
};
