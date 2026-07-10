class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode rightHead = slow.next;
        slow.next = null;
        var list1 = sortList(head);
        var list2 = sortList(rightHead);
        return merge(list1, list2);
    }

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode currunt = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currunt.next = list1;
                list1 = list1.next;
            } else {
                currunt.next = list2;
                list2 = list2.next;
            }
            currunt = currunt.next;
        }

        currunt.next = (list1 == null) ? list2 : list1;
        return dummy.next;
    }
}
