package lc82;

import java.util.HashMap;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
public class Solution {

    /**
     *
     * 两个相邻元素的窗口依次向后遍历，由于链表有序，因此窗口大小只有两种情况：前=后；前<后；这两种情况决定是否将前节点归链。前=后，更新标记位-最后重复值，前<后且前!=最后重复值，把前归链；
     * 使用两个相邻的指针，依次遍历数组：若快指针大于慢指针且慢指针不等于最后一次重复值，则慢指针归链，否则两指针各前进一步，且更新最后一次重复值；
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates2(ListNode head) {

        ListNode distinctDummy = new ListNode(-101);
        ListNode distinct = distinctDummy;
        ListNode slow = head;
        ListNode fast = head;

        int repeatValue = -101;

        // 1,1,1,2,3
        // 1,2,3,3,4,4,5

        // 定义相邻的两个指针-快慢指针，快指针领先慢指针一步
        while (fast != null){
            fast = fast.next;
            if (fast != null){
                if (fast.val > slow.val){
                    // 快指针比慢指针大，且慢指针不等于最后一次重复值，则将慢指针归链
                    if (slow.val != repeatValue){
                        distinct.next = slow;
                        distinct = distinct.next;
                        distinct.next = null;
                    }
                } else {
                    // 快指针=慢指针，更新最后一次重复值
                    repeatValue = fast.val;
                }
                slow = fast;

            } else {
                if (repeatValue != slow.val){
                    distinct.next = slow;
                }
            }
        }
        return distinctDummy.next;
    }


    /**
     * 先遍历一次，使用 hashmap 计数，然后再次遍历拼接联表，不算优秀的解法
     * O(1)
     * O(N)
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
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(5);

        Solution solution = new Solution();
        // 调用 deleteDuplicates 方法
        ListNode result = solution.deleteDuplicates2(head);

        // 打印结果链表
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
