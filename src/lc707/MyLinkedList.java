package lc707;

public class MyLinkedList {

    ListNode head = null;

    Integer length;

    public MyLinkedList() {
        length = 0;
    }

    public int get(int index){
        if (index < 0 || index >= length){
            return -1;
        }
        ListNode p = head;
        while (index > 0){
            index--;
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int value){
        ListNode p = new ListNode();
        p.val = value;
        p.next = head;
        head = p;
        length++;
    }

    public void addAtTail(int value){

        ListNode q = new ListNode();
        q.val = value;

        if (head == null){
            addAtHead(value);
            return;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null){
            prev = curr;
            curr = curr.next;
        }

        prev.next = q;
        length++;
    }

    public void addAtIndex(int index, int value){

        if (index == 0){
            addAtHead(value);
            return;
        } else if (index == length){
            addAtTail(value);
            return;
        } else if (index < 0 || index > length){
            return;
        }

        ListNode q = new ListNode();
        q.val = value;

        ListNode curr = head;
        ListNode prev = null;
        while (index > 0 && curr != null){
            index--;
            prev = curr;
            curr = curr.next;
        }
        prev.next = q;
        q.next = curr;
        length++;
    }

    public void deleteAtIndex(int index){
        if (index < 0 || index >= length){
            return;
        }
        if (index == 0){
            head = head.next;
            length--;
            return;
        }

        ListNode curr = head;
        ListNode prev = null;
        while (index > 0){
            prev = curr;
            curr = curr.next;
            index--;
        }
        prev.next = curr.next;
        length--;
    }

    class ListNode {
        int val;
        ListNode next;
    }
}
