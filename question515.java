import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:36 2018/5/24
 * @Modified By:
 */
public class question515 {
    public int[] findValueMostElement(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        queue.add(root);
        int queueSize = root == null ? 0 : 1;
        while (queueSize > 0) {
            int largestElement = Integer.MIN_VALUE;
            for (int i=0;i<queueSize;i++) {
                TreeNode cur = queue.poll();
                largestElement = Math.max(cur.val, largestElement);
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(largestElement);
            queueSize = queue.size();
        }
        int[] resArray = new int[res.size()];
        for (int i=0;i<res.size();i++) resArray[i] = res.get(i);
        return resArray;
    }
}
