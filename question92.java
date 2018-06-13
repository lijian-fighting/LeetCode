import java.util.List;
import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:54 2018/6/12
 * @Modified By:
 */
public class question92 {
    //内部交换,使用三个索引来标志当前，上一个和下一个节点
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode offList = new ListNode(0);
        offList.next = head;
        ListNode b1 = offList;
        for(int i = 1; i < m ; i++)
            b1 = b1.next;
        ListNode prev = b1.next;
        ListNode curr = prev.next;
        for(int i=m; i < n; i++) {
            ListNode t = curr.next;
            curr.next = prev;
            prev = curr;
            curr = t;
        }
        ListNode t = b1.next;
        b1.next = prev;
        t.next = curr;
        return offList.next;
    }
    public ListNode reverseBetween1(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 0; i < m - 1; i++) {
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        question92 q = new question92();
        System.out.println(q.reverseBetween(test,2,4));

    }
}
