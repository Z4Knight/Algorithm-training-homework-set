class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int p : piles) {
          right = Math.max(p, right);
        }
        while (left < right) {
          int mid = (left + right) / 2;
          if (valid(piles, h, mid)) {
            right = mid;
          } else {
            left = mid + 1;
          }
        }
        return right;
    }

    private boolean valid(int[] piles, int h, int speed) {
        int hours = 0;
        for (int p : piles) {
            // p - 1 可以避免再判断是否需要上取整
            int hourP = (p - 1) / speed + 1;
            // if ((p % speed) == 0) {
            //     hourP = p / speed;
            // }
            hours += hourP;
        }
        return hours <= h;
    }
}
