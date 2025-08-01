package lc373;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

    //     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//        nums1 = [1,7,11]
//        nums2 = [2,4,6]
    // 正确但不合理的方法：
    // 合并 n 个有序链表的思路：nums1的第 i 个元素和 nums2 的每个元素笛卡尔积依次展开 为一个有序链表（如上面case 中第一个链表为：[1,2]->[1,4]->[1,6]）
    // 使用优先级队列，依次从这 n 个链表中取出元素，到第 k 个停止即可
    // 因为这个太耗内存了


    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(nums1.length, (a,b) ->  a.get(0) + a.get(1) - b.get(0) - b.get(1));

        for (int i = 0; i < nums1.length; i++){
            for (int j = 0; j < nums2.length; j++){
                ArrayList<Integer> t = new ArrayList<>();
                t.add(nums1[i]);
                t.add(nums2[j]);
                queue.offer(t);
            }
        }

        while (k>0){
            res.add(queue.poll());
            k--;
        }

        return res;

    }


    //     [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
//        nums1 = [1,7,11]
//        nums2 = [2,4,6]

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        // 构造三元组  [ 数组1中的元素，数组2中的元素，数组2的索引下标 ] ， 该三元组用来笛卡尔积遍历两个数组内的所有元素。
        PriorityQueue<int[]> queue = new PriorityQueue<>(nums1.length, (a,b)-> a[0] + a[1] - b[0] - b [1]);

        // 初始化入队，nums1中的每个元素和 nums2 中的第一个元素入队，初始化完成后，则按照每个nums1 元素固定，依次遍历每个 nums2 元素的顺序遍历
        for (int i = 0; i < nums1.length; i++){
            int[] ints = new int[3];
            ints[0] = nums1[i];
            ints[1] = nums2[0];
            ints[2] = 0;
            queue.offer(ints);
        }

        List res = new ArrayList<List<Integer>>();

        while (k > 0){
            int[] poll = queue.poll();
            k--;

            if (poll[2] + 1 < nums2.length){
                int[] ints = new int[3];
                ints[0] = poll[0];
                ints[1] = nums2[poll[2]+1];
                ints[2] = poll[2] + 1;
                queue.add(ints);
            }


            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(poll[0]);
            tmp.add(poll[1]);
            res.add(tmp);

        }


        return res;



    }

    public static void main(String[] args) {
        // 输入示例
        int[] nums1 = {1, 7, 11};
        int[] nums2 = {2, 4, 6};
        int k = 3;

        Solution solution = new Solution();
        // 调用 kSmallestPairs 方法
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);

        // 打印结果
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
