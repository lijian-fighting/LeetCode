/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:03 2018/6/7
 * @Modified By:
 */
public class question101 {
    public boolean isS(TreeNode root1,TreeNode root2){
        if((root1 == null && root2 != null) || (root1 != null && root2 == null)){
            return false;
        }
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1.val != root2.val){
            return false;
        }
        return isS(root1.left,root2.right) && isS(root1.right,root2.left);
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return true;
        }
        return isS(root.left,root.right);
    }

    public static void main(String[] args) {
        question101 q = new question101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(q.isSymmetric(root));
    }
}
