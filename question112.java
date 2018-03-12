import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:06 2018/2/28
 * @Modified By:
 */
public class question112 {
    //递归遍历整个数组，最后返回子集
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;

        if(root.left == null && root.right == null) return sum == root.val;

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
