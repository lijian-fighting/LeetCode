/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:21 2018/7/19
 * @Modified By:
 */
public class question83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = new ListNode(head.val);
        ListNode start = res;
        int key = head.val;
        ListNode index = head;
        while(index.next != null){
            index = index.next;
            if(index.val == key){
                continue;
            }else{
                start.next = new ListNode(index.val);
                start = start.next;
                key = index.val;
            }
        }
        return res;
    }

    //使用单个索引来跳过，如果相同，跳过，不同的话就往后移
    public ListNode deleteDuplicates1(ListNode head)
    {
        if(head==null || head.next==null )
        {
            return head;
        }
        ListNode slow=head;
        while(slow!=null && slow.next!=null)
        {
            if(slow.val==slow.next.val)
            {
                slow.next=slow.next.next;
            }
            else
            {
                slow=slow.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(1);
        question83 q = new question83();
        System.out.println(q.deleteDuplicates(head));
    }
}
