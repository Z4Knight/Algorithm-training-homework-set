class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length();
        int idx = n - 1;
        //  找到最后一个字母
        while (idx >= 0 && s.charAt(idx) == ' ') {
            idx--;
        }
        int ans = 0;
        // 从当前这个字母继续倒着计数，直到一个空格或者结束
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            ans++;
        }
        return ans;
    }
}
