package lc92;

import data_structure.list.ListNode;

public class Solution {

    // case1
    // 1 -> 2 -> 3 -> 4 -> 5
    // left = 2; right = 4;
    // 1 -> 4 -> 3 -> 2 -> 5

    // case2
    // 1
    // left = 1; right = 1;
    // 1

    // case3
    // 1 -> 2 -> 3
    // left = 1; right = 3;
    // 3 -> 2 -> 1

    // case4
    // 1 -> 2 -> 3
    // left = 1; right = 2;
    // 2 -> 1 -> 3

    // case5
    // 1 -> 2 -> 3
    // left = 2; right = 3;
    // 1 -> 3 -> 2;

    /**
     * 整个链表分成了 3 部分：
     * 前：
     * 中：需要翻转的部分
     * 后：
     *
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {

        // dummy1作为【前段】的最后一个节点，用于衔接【中段】翻转后的第一个节点；
        // dummy2作为【中段】的第一个节点，用于翻转后和【后段】的第一个节点衔接；
        ListNode dummy1 = new ListNode(100);
        ListNode dummy2 = head;

        // prev 和 tmp 是迭代法翻转链表的常规变量
        ListNode prev = null;
        ListNode tmp = null;
        ListNode cur = head;

        int i = 0;

        while (cur != null){
            i++;
            // 正常从头开始遍历，找到 left 开始切分的点：
            // dummy1作为【前段】的最后一个节点，用于衔接【中段】翻转后的第一个节点；
            // dummy2作为【中段】的第一个节点，用于翻转后和【后段】的第一个节点衔接；
            if (i < left){
                dummy1 = cur;
                dummy2 = cur.next;
                cur = cur.next;
            } else if ( i >= left && i <= right ){  // 这一部分的思路就是正常使用迭代法翻转
                tmp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = tmp;
            } else {    // 遍历到【后段】时，直接退出即可，后段没有逻辑需要处理
                break;
            }
        }
        //
        dummy1.next = prev;
        // 此时 dummy2 是【中段】的最后一个节点，将此节点和后续节点衔接
        dummy2.next = cur;

        // 如果是从头开始翻转的，那么 prev 就是最终翻转后的头节点；
        return left == 1 ? prev : head;
    }
}
// case1
// 1 -> 2 -> 3 -> 4 -> 5
// left = 2; right = 4;
// 1 -> 4 -> 3 -> 2 -> 5