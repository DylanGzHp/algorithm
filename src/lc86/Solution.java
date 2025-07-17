package lc86;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}


public class Solution {


    /**
     * 双指针：（不对，太复杂了---错误方案）
     * 1、第一个指针a从头出发遍历到目标节点，第二个指针b从头出发遍历到第一个比目标节点大的节点，记录前一个节点；
     * 2、a 指针开始向后遍历，遇到小于目标的节点，则前插到 b前面的位置；
     *
     *
     * 参考答案
     * 问题本质就是将链表拆为两个，分别是大于 x 的和小于 x 的，然后拼接就好了
     *
     * @param head
     * @param x
     * @return
     * [1,4,3,2,5,2]
     */

    public ListNode partition(ListNode head, int x) {

        if (head == null) return null;

        ListNode gteDummy = new ListNode(-1);
        ListNode lteDummy = new ListNode(-1);

        ListNode cursor = head;
        ListNode p1 = gteDummy;
        ListNode p2 = lteDummy;

        while (cursor != null){
            if (cursor.val >= x){
                p1.next = cursor;
                p1 = p1.next;
                cursor = cursor.next;
                p1.next = null;
            } else if (cursor.val < x){
                p2.next = cursor;
                p2 = p2.next;
                cursor = cursor.next;
                p2.next = null;
            }
        }

        p2.next = gteDummy.next;

        return lteDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        int x = 3;
        Solution solution = new Solution();
        ListNode partition = solution.partition(head, 3);

        while (partition != null) {
            System.out.print(partition.val + " ");
            partition = partition.next;
        }
    }
}
