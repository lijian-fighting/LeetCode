/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:57 2018/3/14
 * @Modified By:
 */
public class question337 {
    //res[0]包含该节点的最大值,res[1]不包含该节点的最大值，从下往上
    public int rob(TreeNode root) {
        int[] num = dfs(root);
        return Math.max(num[0], num[1]);
    }
    private int[] dfs(TreeNode x) {
        if (x == null) return new int[2];
        int[] left = dfs(x.left);
        int[] right = dfs(x.right);
        int[] res = new int[2];
        res[0] = left[1] + right[1] + x.val; //包含该节点
        res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); //不包含该节点
        return res;
    }
}
