class Solution {
    public String reverseWords(String s) {
        int n = s.length();
        char[] chas = s.toCharArray();

        int l = 0;
        int r = 0;
        int firstNoneBlankCh = n;
        while (l < n) {
            while (l < n && chas[l] == ' ') {
               l++;
            }
            r = l;
            while (r < n && chas[r] != ' ') {
               if (firstNoneBlankCh == n) {
                  firstNoneBlankCh = r;
               }
               r++;
            }
            reverse(chas, l, r);
            l = r;
        }
        StringBuilder sb = new StringBuilder();
        r = n - 1;
        while (r >= firstNoneBlankCh) {
            while (r >= 0 && chas[r] == ' ') {
                r--;
            }
            while (r >= 0 && chas[r] != ' ') {
                sb.append(chas[r]);
                r--;
            }
            if (r > firstNoneBlankCh) {
              sb.append(" ");
            }
        }
        // sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
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
