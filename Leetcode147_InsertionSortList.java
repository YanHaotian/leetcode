public class Leetcode147_InsertionSortList {
     // Definition for singly-linked list.
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        // lastSorted：前半段已排序部分的末尾结点
        // curr：后半段未排序的首个结点
        ListNode lastSorted = head, curr = head.next;

        while(curr != null){
            // 如果curr大于等于lastSorted,则curr无需插入，
            // 直接放在已排序的末尾：lastSorted向后移即可
            if (lastSorted.val <= curr.val) {
                lastSorted = lastSorted.next;
            } else {
                ListNode prev = sentinel;
                // 遍历找到curr准备插入的位置
                while (prev.next.val <= curr.val) {
                    prev = prev.next;
                }
                // curr后面的部分接到lastSorted.next
                lastSorted.next = curr.next;
                // 插入curr
                curr.next = prev.next;
                prev.next = curr;
            }
            // 重新指定curr
            curr = lastSorted.next;
        }
        return sentinel.next;
    }
}
