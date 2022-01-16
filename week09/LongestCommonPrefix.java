class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        for (int i = 1; i < strs.length; i++) {
            ans = getCommonPreFix(ans, strs[i]);
        }

        return ans;
    }

    private String getCommonPreFix(String s1, String s2) {
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s1.length() && j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
            sb.append(s1.charAt(i));
            i++;
            j++;
        }
        return sb.toString();
    }
}
