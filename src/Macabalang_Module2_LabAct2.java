import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
}

public class Macabalang_Module2_LabAct2 {

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

    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

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
        Scanner sc = new Scanner(System.in);
        Macabalang_Module2_LabAct2 solver = new Macabalang_Module2_LabAct2();

        System.out.print("Enter number of elements in the list: ");
        int n = sc.nextInt();

        int[] input = new int[n];
        System.out.println("Enter " + n + " integers:");
        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }

        System.out.print("Enter k: ");
        int k = sc.nextInt();

        ListNode head = buildList(input);
        ListNode[] parts = solver.splitListToParts(head, k);

        System.out.println("Resulting splits:");
        for (int i = 0; i < parts.length; i++) {
            System.out.print("S" + (i + 1) + ": ");
            printList(parts[i]);
        }

        sc.close();
    }
}

