class Leetcode707_MyLinkedList {
    public class ListNode{
        int val;
        ListNode prev;
        ListNode next;

        public ListNode(int x, ListNode p, ListNode n) {
            val = x;
            prev = p;
            next = n;
        }
    }

    int size;
    ListNode head, tail;

    /** Initialize your data structure here. */
    public Leetcode707_MyLinkedList() {
        size = 0;
        head = new ListNode(0, null, null);
        tail = new ListNode(0, head, null);
        head.next = tail;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < size) {
            ListNode p = head;
            int position = index;
            while (position > 0) {
                p = p.next;
                position -=1;
            }
            return p.next.val;
        } else {
            return -1;
        }
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        head.next = new ListNode(val, head, head.next);
        head.next.next.prev = head.next;
        size += 1;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        tail.prev.next = new ListNode(val,tail.prev, tail);
        tail.prev = tail.prev.next;
        size += 1;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        ListNode p = head;
        int position = index;
        while (position > 0) {
            p = p.next;
            position -=1;
        }
        p.next = new ListNode(val, p, p.next);
        p.next.next.prev = p.next;
        size += 1;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < size) {
            ListNode p = head;
            int position = index;
            while (position > 0) {
                p = p.next;
                position -=1;
            }
            p.next = p.next.next;
            p.next.prev = p;
            size -= 1;
        }
    }


    public static void main(String[] args) {
        Leetcode707_MyLinkedList obj = new Leetcode707_MyLinkedList();
        obj.addAtHead(1);
        obj.addAtHead(2);
        obj.addAtHead(3);
        obj.addAtTail(4);
        obj.addAtIndex(2, 5);
        obj.deleteAtIndex(4);
        obj.get(3);
        System.out.println("0325140");
        System.out.println(obj.head.val);
        System.out.println(obj.head.next.val);
        System.out.println(obj.head.next.next.val);
        System.out.println(obj.head.next.next.next.val);
        System.out.println(obj.head.next.next.next.next.val);
        System.out.println(obj.head.next.next.next.next.next.val);
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */