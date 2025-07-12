package lc21;

public class Solution {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }





    /**
     * 双指针 - 未构建虚拟节点，会导致代码相对复杂
     * O(m+n)
     * O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 某一个链表为空的处理
        if (list1 == null){
            return list2;
        } else if (list2 == null) {
            return list1;
        }

        // 构建一个指针，用于在新链表中不断拼接节点
        ListNode tmp = null;

        ListNode walker1 = list1;
        ListNode walker2 = list2;

        // 确定第一个节点来自于哪个链表，后续迭代时就不包含这个节点，而是从这个节点的 next 开始 与 另一条链表从头开始迭代
        if (walker1.val <= walker2.val){
            tmp = walker1;
            walker1 = walker1.next;
        } else {
            tmp = walker2;
            walker2 = walker2.next;
        }

        // 此处开始迭代，不包含第一个节点
        while (walker1 != null && walker2 != null){
            if (walker1.val <= walker2.val){
                tmp.next = walker1;
                tmp = tmp.next;
                walker1 = walker1.next;
            } else {
                tmp.next = walker2;
                tmp = tmp.next;
                walker2 = walker2.next;
            }
        }
        // 将剩余节点拼进去
        if (walker1 != null){
            tmp.next = walker1;
        }
        if (walker2 != null){
            tmp.next = walker2;
        }
        // 由于没改变过 list1 和 list2 节点的指向，因此直接返回这两个节点即可
        return list1.val <= list2.val ? list1 : list2;
    }


    /**
     * 构建虚拟头节点 ListNode dummy = new ListNode(-1);，后面直接返回 dummy.next 就是目标链表；
     * O(m+n)
     * O(1)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);

        ListNode cursor = dummy;

        while (list1 != null && list2 != null){
            if (list1.val <= list2.val){
                cursor.next = list1;
                list1 = list1.next;
            } else {
                cursor.next = list2;
                list2 = list2.next;
            }
            cursor = cursor.next;
        }
        if (list1 != null){
            cursor.next = list1;
        }
        if (list2 != null){
            cursor.next = list2;
        }
        return dummy.next;
    }
}
