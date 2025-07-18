package lc160;

import java.util.HashSet;

public class Solution {
    
    
      public class ListNode {
          int val;
          ListNode next;

          ListNode(int x) {
              val = x;
              next = null;
          }
      }

      /**
       * 定义一个 set，每个支线的节点遍历后都将节点存入 set 中，第一个 contains 的就是相交节点
       * @param headA
       * @param headB
       * @return
       */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        HashSet<ListNode> listNodes = new HashSet<>();

        while (headA != null){
            listNodes.add(headA);
            headA = headA.next;
        }

        while (headB != null){
            if (listNodes.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }

        return null;

    }


    /**
     * 两个分支指针同时出发，让一个分支的指针先跑到头，开始计数，另一个指针从此时开始跑到头执行的次数就是长链比短链多的节点数，从头开始遍历，长链先出发对应节点数之后，长短链一起出发，相等时即汇聚点
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {

        ListNode walkerA = headA;
        ListNode walkerB = headB;

        while (walkerA != null && walkerB != null){
            walkerA = walkerA.next;
            walkerB = walkerB.next;
        }
        int extraA = 0;
        int extraB = 0;
        while (walkerA != null){
            extraA++;
            walkerA = walkerA.next;
        }
        while (walkerB != null){
            extraB++;
            walkerB = walkerB.next;
        }
        while (extraA > 0){
            headA = headA.next;
            extraA--;
        }
        while (extraB > 0){
            headB = headB.next;
            extraB--;
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;

    }
}
