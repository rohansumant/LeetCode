class Solution {
  public:

    void partition(vector<int> &a, int x) {
      int n = a.size();
      for (int i=0, j=-1;
          i < n; i++) {
        if (a[i] < x) {
          if (j != -1) {
            swap(a[i],a[j]);
            j++;
          }
        }
        else if (j == -1) j = i;
      }
    }

    void sortColors(vector<int>& nums) {
      partition(nums,1);
      partition(nums,2);
    }
};
