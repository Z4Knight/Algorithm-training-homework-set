class Solution {
    public int repeatedStringMatch(String a, String b) {

        int max = 1;
        int n = a.length();
        int m = b.length();
        if (n < m) {
        // 最大的叠加次数，当 a 的长度大于等于 b 的两倍长度
          while (n <= 2 * m) {
              n += a.length();
              max++;
          }
        } else {
          max = 2;
        }
        int left = 1;
        int right = max + 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (isValid(a, b, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (right == max + 1) {
            return -1;
        }
        return right;
    }

    private boolean isValid(String s1, String s2, int count) {
        int b = 131;
        int p = 1000000007;
        StringBuilder sb = new StringBuilder();
        while (count > 0) {
             sb.append(s1);
             count--;
        }
        s1 = sb.toString();
        int n = s1.length();
        int m = s2.length();
        long[] h = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            h[i] = (h[i - 1] * b + s1.charAt(i - 1) - 'a' + 1) % p;
        }

        long powB = 1;
        long hB = 0;
        for (char ch : s2.toCharArray()) {
            hB = (hB * b + ch - 'a' + 1) % p;
            powB = powB * b % p;
        }

        for (int l = 1; l <= n - m + 1; l++) {
            int r = l + m - 1;
            if (((h[r] - h[l - 1] * powB) % p + p) % p == hB) {
                return true;
            }
        }

        return false;
    }
}
