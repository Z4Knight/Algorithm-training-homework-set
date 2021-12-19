class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, target);
        if (row == -1) {
          return false;
        }

        return binarySearchIn(matrix[row], target);
    }

    private int binarySearchRow(int[][] matrix, int target) {
      int left = -1;
      int right = matrix.length - 1;
      while (left < right) {
        int mid = (left + right + 1) / 2;
        if (matrix[mid][0] <= target) {
          left = mid;
        } else {
          right = mid - 1;
        }
      }
      return right;
    }

    private boolean binarySearchIn(int[] nums, int target) {
      int left = 0;
      int right = nums.length - 1;
      while (left <= right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
          return true;
        }
        if (nums[mid] < target) {
          left = mid + 1;
        } else {
          right = mid - 1;
        }
      }
      return false;
    }
}
