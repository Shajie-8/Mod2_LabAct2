class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class MyLinkedList {

    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] result = new ListNode[k];

        int length = 0;
        ListNode node = head;
        while (node != null) {
            length++;
            node = node.next;
        }

        int baseSize = length / k;
        int extra = length % k;

        node = head;
        for (int i = 0; i < k; i++) {
            if (node == null) {
                result[i] = null;
                continue;
            }

            result[i] = node;
            int currentSize = baseSize + (i < extra ? 1 : 0);

            for (int j = 0; j < currentSize - 1; j++) {
                node = node.next;
            }

            ListNode next = node.next;
            node.next = null;
            node = next;
        }

        return result;
    }

    // Helper to build a linked list from an array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    // Helper to print a linked list part
    public static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        MyLinkedList solver = new MyLinkedList();

        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ListNode head = buildList(input);
        int k = 3;

        ListNode[] parts = solver.splitListToParts(head, k);

        for (ListNode part : parts) {
            printList(part);
        }
    }
}


