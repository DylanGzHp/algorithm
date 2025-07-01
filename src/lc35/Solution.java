package lc35;

public class Solution {

    public static void main(String[] args) {
        int[] arr= new int[]{1,3,5,6};
        int target=2;
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(arr, target));
    }


    /**
     * 二分查找框架
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = left + ( right - left ) / 2;
            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] > target){
                right = mid - 1;
            } else if (nums[mid] < target){
                left = mid + 1;
            }
        }
        return left;
    }
}
