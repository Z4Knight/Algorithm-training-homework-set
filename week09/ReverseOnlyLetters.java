class Solution {
    public String reverseOnlyLetters(String s) {
        char[] chas = s.toCharArray();
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            while (l < n && !isLetter(chas[l])) {
               l++;
            }
            while (r > l && !isLetter(chas[r])) {
              r--;
            }
            if (l < r) {
                swap(chas, l, r);
            }
            l++;
            r--;
        }
        return new String(chas);
    }

    private boolean isLetter(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
