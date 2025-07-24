package lc83;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {


    /**
     * 向后遍历，遇到大于的值则拼接到链表后面即可，使用 dummyNode 的 trick
     * O(N)
     * O(1)
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode fast = head;


        ListNode dummy = new ListNode(-101);

        ListNode slow = dummy;

        // 1,1,2,3,3
        while (fast != null){
            if (fast.val > slow.val){
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
            slow.next = null;
        }
        return dummy.next;
    }
}
