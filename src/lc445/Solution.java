package lc445;

import data_structure.list.ListNode;

public class Solution {

    public static void main(String[] args) {
        // 示例输入: l1 = [7,2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(7);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        // 调用 addTwoNumbers 方法
        ListNode result = solution.addTwoNumbers(l1, l2);

        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }



    /**
     * 依次翻转链表，然后按照低位依次相加的写法处理
     * @param l1
     * @param l2
     * @return
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // [7,2,4,3]
        // 翻转l1
        ListNode cur1 = l1;
        ListNode prev1 = null;
        ListNode tmp = null;

        while (cur1 != null){
            tmp = cur1.next;
            cur1.next = prev1;
            prev1 = cur1;
            cur1 = tmp;
        }
        // [5,6,4]
        // 翻转 l2
        ListNode cur2 = l2;
        ListNode prev2 = null;

        while (cur2 != null){
            tmp = cur2.next;
            cur2.next = prev2;
            prev2 = cur2;
            cur2 = tmp;
        }

        // prev1 and prev2 are the reversed linked lists, do the addition algo
        cur1 = prev1;
        cur2 = prev2;
        boolean need1 = false;
        ListNode dummy = new ListNode(-1);
        tmp = dummy;
        while (cur1 != null && cur2 != null){
            int value = cur1.val + cur2.val;
            if (need1){
                value+=1;
                need1 = false;
            }
            if (value >= 10){
                value-=10;
                need1 = true;
            }
            tmp.next = new ListNode(value);
            tmp = tmp.next;
            cur1 = cur1.next;
            cur2 = cur2.next;
        }

        while (cur1 != null){
            int value = cur1.val;
            if (need1){
                value+=1;
                need1 = false;
            }
            if (value>=10){
                value-=10;
                need1=true;
            }
            tmp.next = new ListNode(value);
            tmp = tmp.next;
            cur1 = cur1.next;
        }

        while (cur2 != null){
            int value = cur2.val;
            if (need1){
                value+=1;
                need1 = false;
            }
            if (value>=10){
                value-=10;
                need1=true;
            }
            tmp.next = new ListNode(value);
            tmp = tmp.next;
            cur2 = cur2.next;
        }

        if (need1){
            tmp.next = new ListNode(1);
            tmp = tmp.next;
        }
        // take the unreversed linked list
        tmp = dummy.next;
        // reverse the final linked list
        ListNode cur = tmp;
        ListNode prev = null;
        ListNode p = null;

        while (cur != null){
            p = cur.next;
            cur.next = prev;
            prev = cur;
            cur = p;
        }

        return prev;

    }
}
