class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> jewelCnt = new HashMap<>();

        for (char ch : stones.toCharArray()) {
            int cnt = jewelCnt.getOrDefault(ch, 0);
            jewelCnt.put(ch, cnt + 1);
        }

        int ans = 0;
        for (char ch : jewels.toCharArray()) {
            if (jewelCnt.containsKey(ch)) {
                ans += jewelCnt.get(ch);
            }
        }

        return ans;
    }
}
