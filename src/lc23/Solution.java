package lc23;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {


    /**
     * 使用优先级队列 - 大根堆、小根堆
     * 将全部联表的元素都入堆，然后依次从堆中取出组合成链即可，但是需要注意，取出堆中的节点时，各个节点是独立的，需要置空 next，否则会可能成环。
     * O(NlogN)
     * O(N)
     *
     *
     * 还有一种利用优先级队列的解法：
     * 只把每条联表的头节点入堆
     * 然后每次取出这些堆中节点的最小值，取出后把最小值的 next 指向的节点再入堆，时刻保证堆中的元素个数只有 k 个（k 为链表条数）
     * 此解法比上面的方法节约时间复杂度和空间复杂度
     * O(Nlogk)
     * O(k)
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<ListNode>(500, (o1, o2) -> o1.val > o2.val? 1 : -1);


        ListNode head = new ListNode(-1);
        ListNode cur = head;

        for (ListNode list : lists) {
            while (list!=null){
                // 入堆，时间复杂度 O(logN)，即和树的深度正相关
                listNodePriorityQueue.add(list);
                list=list.next;
            }
        }

        while (!listNodePriorityQueue.isEmpty()){
            // 出堆，时间复杂度 O(logN)，即和树的深度正相关
            ListNode poll = listNodePriorityQueue.poll();
            // 取出后要置空
            poll.next = null;
            cur.next = poll;
            cur = cur.next;
        }

        return head.next;

    }


    // 将二维数组转换为链表数组
    public static ListNode[] generateInput(int[][] lists) {
        ListNode[] result = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            result[i] = createLinkedList(lists[i]);
        }
        return result;
    }

    // 辅助方法：从数组创建一个链表
    public static ListNode createLinkedList(int[] array) {
        if (array.length == 0) return null;
        ListNode dummy = new ListNode(-1); // 虚拟头节点
        ListNode current = dummy;
        for (int val : array) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        int[][] input = {{-1, -1, -1}, {-2, -2, -1}};
        ListNode[] lists = generateInput(input);

        // 打印链表数组
        Solution solution = new Solution();
        solution.mergeKLists(lists);
    }
    
}
