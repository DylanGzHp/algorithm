package lc378;

import java.util.HashMap;
import java.util.PriorityQueue;

public class Solution {

//    [[1,5,9],[10,11,13],[12,13,15]], k = 8

    /**
     * 整体思路：合并 k 个有序链表的变种
     * 使用优先级队列，每一行从头开始的元素依次进入队列，然后取出队列元素，即为全局排序好的元素
     * @param matrix
     * @param k
     * @return
     */
    public int kthSmallest(int[][] matrix, int k) {



        // 使用一个三元素数组表示一个节点 [元素值，所在行，所在列]

        // 定义优先级队列，队列的每个元素是一个三元组，每次从中取出当次排序最小的元组所代表的行
        PriorityQueue<int[]> queue = new PriorityQueue<>(matrix.length,(a,b) -> a[0] - b[0]);

        // 初始化优先级队列，将每行入队，每个元素为：(每行第 1 个值，行号=i，列号=0)
        for (int i = 0 ; i < matrix.length; i++){
            queue.offer(new int[]{matrix[i][0], i, 0});
        }

        int res = Integer.MIN_VALUE;
        int row = -1;
        int col = -1;
        while (k > 0){
            int[] poll = queue.poll();
            res = poll[0];
            row = poll[1];
            col = poll[2];

            if (col + 1 < matrix.length){
                queue.offer(new int[]{matrix[row][col+1], row, col+1});
            }
            k--;
        }

        return res;
    }

}
