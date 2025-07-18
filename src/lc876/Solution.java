package lc876;



class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Solution {


    /**
     * 快慢指针，快指针步长为 2，慢指针步长为 1 即可
     * 注意快指针遍历中间的 if 判空，恰好就是遍历步长奇数偶数的判断节点
     *
     * O(N)
     * O(1)
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null){
            fast = fast.next;
            if (fast == null){
                // 奇数个节点，fast在此处遍历结束
                return slow;
            } else {
                // 偶数个节点
                fast = fast.next;

            }

            slow = slow.next;

        }
        return slow;
    }


}
