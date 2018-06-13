import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:36 2018/6/13
 * @Modified By:
 */
public class question144 {
    private List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            res.add(temp.val);
            if(temp.right != null){
                s.add(temp.right);
            }
            if(temp.left != null){
                s.add(temp.left);
            }
        }
        return res;
    }
    // root left right
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();

        preorderTraversalHelper(root, result);

        return result;
    }

    private List<Integer> preorderTraversalHelper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        list.add(node.val);

        preorderTraversalHelper(node.left, list);
        preorderTraversalHelper(node.right, list);

        return list;
    }
}
