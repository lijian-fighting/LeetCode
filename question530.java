import sun.reflect.generics.tree.Tree;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:56 2018/4/23
 * @Modified By:
 */
public class question530 {
    int min = Integer.MAX_VALUE;
    TreeNode pre;
    public int getMinimumDifference(TreeNode root){
        inorder(root);
        return min;
    }
    private void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        if(pre != null) min = Math.min(min,root.val - pre.val);
        pre = root;
        inorder(root.right);
    }
}
