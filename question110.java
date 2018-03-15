/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:55 2018/3/15
 * @Modified By:
 */
public class question110 {
    //使用一个方法求解深度即可.
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(depth(root.left) - depth(root.right)) >1)
            return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode root){
        if (root == null)
            return 0;
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }
}
