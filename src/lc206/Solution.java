package lc206;

import data_structure.list.ListNode;

import java.sql.Array;
import java.util.ArrayList;

public class Solution {


    /**
     * 迭代方法
     * 翻转链表 - 定义三个指针，cur、prev，不断以这两个指针向后遍历，将 cur -> prev 即可，需注意的就是要额外定义一个 tmp 指针，保存 cur，因为 cur 改变指向到 prev 之后，就会和后面的脱开了。
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode cur = head;
        ListNode prev = null;

        ListNode tmp = null;
        while (cur != null){
            tmp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmp;
        }

        return prev;
    }

    public ListNode reverseList2(ListNode head){
        ArrayList<ListNode> listNodes = new ArrayList<>(1);
        recursively(head, listNodes);
        return listNodes.get(0);
    }

    public ListNode recursively(ListNode head, ArrayList<ListNode> dummy){

        if (head == null || head.next == null){
            dummy.add(head);
            return head;
        }
        ListNode listNode = recursively(head.next, dummy);

        listNode.next = head;
        head.next = null;
        return head;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode second = new ListNode(2);
        ListNode first = new ListNode(1, second);

        ListNode listNode = solution.reverseList2(first);
        System.out.println(3);
    }

    // 1 <- 2 -> 3 -> 4

    public ListNode reverseList3(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode listNode = reverseList3(head);
        head.next.next = head;
        head.next = null;
        return listNode;
    }




}
