/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:38 2018/7/2
 * @Modified By:
 */
public class question226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}
