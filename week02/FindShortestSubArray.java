class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> h = new HashMap<>();

        for (int num : nums) {
            int cnt = h.getOrDefault(num, 0);
            h.put(num, cnt + 1);
        }
        // h = {1=2, 2=2, 3=1} 值 和 它的频数
        int maxDegree = 0;
        for (int k : h.keySet()) {
            maxDegree = Math.max(maxDegree, h.get(k));
        }
        List<Integer> maxDegreeVals = new ArrayList<>();
        for (int k : h.keySet()) {
            if (h.get(k).equals(maxDegree)) {
                maxDegreeVals.add(k);
            }
        }
        int ans = nums.length;
        for (int val : maxDegreeVals) {
            int dist = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == val) {
                    dist = i;
                    break;
                }
            }

            for (int i = nums.length - 1; i >= 0; i--) {
                if (nums[i] == val) {
                    dist = i - dist;
                    ans = Math.min(ans, dist + 1);
                    break;
                }
            }
        }

        return ans;


    }
}
