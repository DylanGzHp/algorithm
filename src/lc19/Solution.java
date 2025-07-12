package lc19;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    /**
     * 删除倒数第 n 个节点，就相当于两个指针，相差 n 次遍历相继出发，其中一个指针遍历结束时，第二个指针所指的恰好就是倒数第 n 个节点；
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;
        ListNode slowPrev = head;

        while (n > 0){
            fast = fast.next;
            n--;
        }

        // （只有一个节点的特例是从头结点开始删除的一个子特例）从头节点开始删除的特例，说明 n-- 的处理就已经使 fast 到末尾了，此时直接删除头节点即可，无需处理其他的指针，return 之后会自动释放内存空间。
        if (fast == null){
            head = head.next;
            return head;
        }

        while (fast != null){
            fast = fast.next;
            slowPrev = slow;
            slow = slow.next;
        }

        slowPrev.next = slow.next;

        return head;
    }
    
}
