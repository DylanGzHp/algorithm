package lc206;

import data_structure.list.ListNode;

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






}
