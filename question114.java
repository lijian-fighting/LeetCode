/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:38 2018/5/8
 * @Modified By:
 */
public class question114 {
    //递归
    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;

        flatten(left);
        flatten(right);

        root.right = left;
        TreeNode cur = root;
        while (cur.right != null) cur = cur.right;
        cur.right = right;
    }
}
