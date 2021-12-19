class Solution {
    public int findMin(int[] nums) {
        // [3,3,3,0,0,1]  nums[i] <= nums[r] ? 1 : 0
        //  0,0,0,1,1,1
        // [1,3,5,5,5,5,5,5,5]
        //
        // 第一个 <= nums[r] =》最小的
        // [3,3,1,3]
        //  1,1,1,1
        //  0,0,1,0
        // [1,1,1,1,1]
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == nums[right]) {
                right -= 1;
            } else if (nums[mid] > nums[right]){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}
