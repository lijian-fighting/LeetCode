/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:55 2018/5/15
 * @Modified By:
 */
public class question450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            TreeNode temp = finmin(root.right);
            root.val = temp.val;
            root.right = deleteNode(root.right,root.val);
        }
        return root;
    }
    private TreeNode finmin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }
}
