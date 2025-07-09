package lc142;

import java.util.HashSet;
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

    /**
     * 哈希表记录遍历过的节点，hash 中第一个重复出现的元素即为起点
     * O(N)
     * O(N)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();

        while (head != null){
            if (set.contains(head)){
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    /**
     * 快慢指针：
     * 1、若快慢指针相遇，则说明有环，相遇点一定是在环上；
     * 2、此时在相遇点：slow 走的距离是上环前的 a 个节点 + 环上的 b 个节点；fast 走的是上环前的 a 个节点 + 环上的 b 个节点 + 若干圈环 c
     * 3、fast 和 slow 走过的距离是 2：:1，因此若干圈环 c 的节点数 = a + b；即 kc=a+b
     * 4、即：上环前的节点数 a + 环上相遇节点前的 b 个节点 = 环 c 的 k 倍
     * 5、两面同时减去 b 的节点：即上环的节点数 a =(k - 1)圈 + 从相遇点继续跑到入环点的距离；
     * 6、因此此时，在第一次相遇时，用两个指针分别从相遇点和 head 开始依次遍历，相遇的地方就是入环点
     *
     * @param head
     * @return
     */
    public ListNode detectCycleO1(ListNode head){

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null){

            slow = slow.next;
            fast = fast.next;
            if (fast == null){
                return null;
            }
            fast = fast.next;

            if (fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;

    }

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

        System.out.println(solution.detectCycle(head));
    }
}
