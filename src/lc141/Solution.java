package lc141;

import java.util.List;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = new int[]{1,1,1,1};
        int pos = -1;
        ListNode head = null;
        ListNode prev = null;
        ListNode circleEnd = null;
        for (int i = 0; i < arr.length; i++){
            ListNode cur = new ListNode(arr[i]);
            if (i == 0){
                head = cur;
                prev = cur;
            } else {
                prev.next = cur;
                prev = cur;
            }
            if (i == pos){
                circleEnd = cur;
            }
            if (i == arr.length - 1){
                cur.next = circleEnd;
            }
        }


//        while (head != null){
//            System.out.println(head.val);
//            head = head.next;
//        }

        System.out.println(solution.hasCycle(head));
    }


    /**
     * 快慢指针，慢的每次前进 1，快的每次前进 2，如果快的追上慢的，就说明有环
     * 时间：O(N)
     * 空间：O(1)
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {

        if (head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (slow != null && fast != null){
            if (slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                return false;
            } else {
                fast = fast.next;
            }
        }
        return false;
    }
}