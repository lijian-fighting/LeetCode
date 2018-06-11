import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:03 2018/6/11
 * @Modified By:
 */
public class question23 {
    public ListNode mergeKLists1(ListNode[] lists) {
        PriorityQueue<ListNode> res = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode temp:lists){
            if(temp != null) {
                res.add(temp);
            }
        }
        ListNode r = new ListNode(0);
        ListNode head = r;
        while(!res.isEmpty()){
            ListNode temp = res.poll();
            if(temp != null) {
                r.next = new ListNode(temp.val);
                r = r.next;
                temp = temp.next;
                if(temp != null) {
                    res.add(temp);
                }
            }
        }
        return head.next;
    }
public ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0)
        return null;
    return merge(0,lists.length-1,lists);
}
    public ListNode merge(int i,int j,ListNode[] lists) {
        if(j<i)return null;
        if(i==j)return lists[i];
        int mid=i+(j-i)/2;
        ListNode l=merge(i,mid,lists);
        ListNode r= merge(mid+1,j,lists);
        ListNode dummy =new ListNode(0);
        ListNode runner= dummy;

        while(l!=null && r!=null) {
            if(l.val>r.val) {
                runner.next=r;
                r=r.next;
                runner=runner.next;
            }
            else {
                runner.next=l;
                l=l.next;
                runner=runner.next;
            }
        }
        if(l==null && r==null)
            return dummy.next;
        if(l==null)
            runner.next=r;
        else
            runner.next=l;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode []temp = new ListNode[3];
        temp[0] = new ListNode(1);
        temp[0].next = new ListNode(4);
        temp[0].next.next = new ListNode(5);
        temp[1] = new ListNode(1);
        temp[1].next = new ListNode(3);
        temp[1].next.next = new ListNode(4);
        temp[2] = new ListNode(2);
        temp[2].next = new ListNode(6);
        question23 q = new question23();
        ListNode res = q.mergeKLists(temp);
        while(res != null){
            System.out.println(res.val);
            res = res.next;
        }

    }
}
