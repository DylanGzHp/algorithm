package lc2;

import data_structure.list.ListNode;

public class Solution {


    /**
     * 双指针遍历即可，额外定义一个是否进一的标志位，每轮遍历时，先加上进一位，若再有进一，继续更新进一位
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode p = dummy;
        ListNode p1 = l1;
        ListNode p2 = l2;

        boolean need1 = false;
        while (p1 != null && p2 != null){

            int value = p1.val + p2.val;
            if (need1){
                value += 1;
                need1 = false;
            }

            if (value >= 10) {
                value = value - 10;
                need1 = true;
            }

            ListNode listNode = new ListNode(value);
            p.next = listNode;
            p = p.next;

            p1 = p1.next;
            p2 = p2.next;
        }

        while ( p1 != null){
            int value = p1.val;
            if (need1){
                value += 1;
                need1 = false;
            }
            if (value >= 10){
                value = value - 10;
                need1 = true;
            }
            ListNode listNode = new ListNode(value);
            p.next = listNode;
            p = p.next;

            p1 = p1.next;
        }

        while ( p2 != null){
            int value = p2.val;
            if (need1){
                value += 1;
                need1 = false;
            }
            if (value >= 10){
                value = value - 10;
                need1 = true;
            }
            ListNode listNode = new ListNode(value);
            p.next = listNode;
            p = p.next;

            p2 = p2.next;
        }

        if (need1){
            ListNode listNode = new ListNode(1);
            p.next = listNode;
        }

        return dummy.next;

    }
    
}
