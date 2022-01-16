class Solution {
    public String reverseWords(String s) {
      int n = s.length();
      char[] chas = s.toCharArray();
      int l = 0;
      int r = 0;
      while (l < n) {
          while (l < n && chas[l] == ' ') {
             l++;
          }
          r = l;
          while (r < n && chas[r] != ' ') {
             r++;
          }
          reverse(chas, l, r);
          l = r;
      }
      return new String(chas);
    }

    private void reverse(char[] s, int l, int r) {
        int i = l;
        int j = r - 1;
        if (r >= s.length - 1) {
            j = s.length - 1;
        }
        while (i < j) {
            swap(s, i, j);
            i++;
            j--;
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
