import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:47 2018/3/1
 * @Modified By:
 */
public class question105 {
    //根据中序和左序的遍历方式，中序先中间，可以找到根节点，在左序中，根节点的左边左孩子，右边右孩子，然后递归调用。
    //注意需要找到每一次递归的根节点
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0; // Index of current root in inorder
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }
}
