class Solution {
    public String reverseStr(String s, int k) {
        char[] chas = s.toCharArray();
        int l = 0;
        int r = l + k;
        while (l < s.length()) {
            reverse(chas, l, r);
            l = r + k;
            r = l + k;
        }
        return new String(chas);
    }

    private void reverse(char[] s, int l, int r) {
        int i = l;
        int j = r - 1;
        if (j >= s.length) {
            j = s.length - 1;
        }
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i , int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
