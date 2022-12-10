class Solution {
public:
    int pivotInteger(int n) {
        int x_sq = (n*(n+1))/2;
        double x = sqrt(x_sq);
        if (floor(x) == ceil(x)) return x;
        return -1;
    }
};
