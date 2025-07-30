package lc373;

import java.util.ArrayList;
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

        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
            return (a[0] + a[1]) - (b[0] + b[1]);
        });
        // 按照 23 题的逻辑初始化优先级队列
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        // 执行合并多个有序链表的逻辑
        while (!pq.isEmpty() && k > 0) {
            int[] cur = pq.poll();
            k--;
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            List<Integer> pair = new ArrayList<>();
            pair.add(cur[0]);
            pair.add(cur[1]);
            res.add(pair);
        }
        return res;

    }
}
