package lc1991;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{2,5};
        System.out.println(solution.findMiddleIndex2(arr));
    }

    /**
     * 暴力解法-直接遍历每个元素，遍历时分别计算左右的元素和
     * 时间：O(n^2)
     * 空间：O(n)
     * @param nums
     * @return
     */
    public int findMiddleIndex(int[] nums) {

        int target  = -1;

        for (int i = 0; i < nums.length; i++){
            int leftSum = 0;
            int rightSum = 0;
            for (int j = 0; j < i; j++){
                leftSum += nums[j];
            }
            for (int k = nums.length - 1; k > i; k--){
                rightSum+=nums[k];
            }
            if (rightSum == leftSum){
                target = i;
                return target;
            }
        }

        return target;
    }

    /**
     * 公式法- 某元素左右两侧和相等 => 左侧和 * 2 + 元素 = 全数组求和
     * 时间-O(n)
     * 空间-
     * @param nums
     * @return
     * 2,3,-1,8,4
     */
    public int findMiddleIndex2(int[] nums) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++){
            if (leftSum * 2 + nums[i] == total){
                return i;
            }
            leftSum+=nums[i];
        }
        return -1;
    }
}
