import java.util.HashSet;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:11 2018/5/15
 * @Modified By:
 */
public class question572 {
    HashSet < String > trees = new HashSet< >();
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    public String preorder(TreeNode t, boolean left) {
        if (t == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        return "#"+t.val + " " +preorder(t.left, true)+" " +preorder(t.right, false);
    }
}
