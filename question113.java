import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:25 2018/3/28
 * @Modified By:
 */
public class question113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> path = new ArrayList();
        dfs(root, sum, res, path);
        return res;
    }

    //回溯法需要保存当前值，如果不满足或者满足都需要将最后一个删除。
    //If we execute two sub recursive code in else branch and still can’t get a match pathSum,
    // this means the current “root” which already added into the List currentResult can not lead us to the correct answer.
    // So we need to remove it from List currentResult and try other possible branches, this is what backtracking means.
    private void dfs(TreeNode root, int sum, List<List<Integer>> res, List<Integer> path) {
        if (root == null)
            return;
        path.add(root.val);
        if (root.left == null && root.right == null && root.val == sum)
            res.add(new ArrayList(path));
        dfs(root.left, sum - root.val, res, path);
        dfs(root.right, sum - root.val, res, path);
        path.remove(path.size() - 1);
    }
}
