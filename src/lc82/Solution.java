package lc82;

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    // [1,2,3,3,4,4,5]

    /**
     * 先遍历一次计数，然后拼接联表
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {

        ListNode tmp = head;
        ListNode dummy = new ListNode(-101);
        ListNode prev = dummy;

        HashMap<Integer, Integer> cm = new HashMap<>();

        while (tmp != null){
            Integer orDefault = cm.getOrDefault(tmp.val, 0);
            cm.put(tmp.val, orDefault+1);
            tmp = tmp.next;
        }

        tmp = head;
        while (tmp!= null){
            if (cm.get(tmp.val) == 1){
                prev.next = tmp;
                prev = prev.next;
                tmp = tmp.next;
                prev.next = null;
            } else {
                tmp = tmp.next;
            }
        }
        return dummy.next;


    }


    public static void main(String[] args) {
        // 示例输入: 链表 [1,2,3,3,4,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        // 调用 deleteDuplicates 方法
        ListNode result = solution.deleteDuplicates(head);

        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
