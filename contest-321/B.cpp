class Solution {
public:
    int appendCharacters(string s, string t) {
        int i = 0, j = 0;
        for (;i<t.size();i++) {
            while (j < s.size() && s[j] != t[i]) j++;
            if (j == s.size()) {
                break;
            } else j++;
        }
        if (i == t.size()) return 0; // already good
        else return t.size() - i;
    }
};
