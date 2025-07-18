package lcr140;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {


    /**
     * 快慢指针，找链表倒数第 n 个节点
     * @param head
     * @param cnt
     * @return
     */
    public ListNode trainingPlan(ListNode head, int cnt) {

        ListNode fast = head;
        ListNode slow = head;

        while ( cnt > 0 ){
            fast = fast.next;
//            if (fast == null){
//                return null;
//            }
            cnt--;
        }

        while (fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    
}
