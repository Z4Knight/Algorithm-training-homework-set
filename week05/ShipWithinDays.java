class Solution {
    public int shipWithinDays(int[] weights, int days) {
      int left = 0;
      int right = 0;
      for (int weight : weights) {
        right += weight;
        left = Math.max(left, weight);
      }

      while (left < right) {
        int mid = (left + right) / 2;
        if (valid(weights, days, mid)) {
          right = mid;
        } else {
          left = mid + 1;
        }
      }

      return right;
    }

    private boolean valid(int[] weights, int days, int capacity) {
      // 需要的天数
      int needDays = 1;
      // 累积重量
      int sum = 0;
      for (int weight : weights) {
        if (sum + weight <= capacity) {
          sum += weight;
        } else {
          sum = weight;
          needDays++;
        }
      }
      return needDays <= days;
    }
}
