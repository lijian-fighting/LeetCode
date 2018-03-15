/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:01 2018/3/15
 * @Modified By:
 */
public class question100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if( p == null && q == null){
            return true;
        }else if( (p == null && q!=null) || (p != null && q==null)){
            return false;
        }

        if(p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }else{
            return false;
        }
    }
}
