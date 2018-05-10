import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:08 2018/5/8
 * @Modified By:
 */
public class question448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        boolean[] check = new boolean[n+1];
        List<Integer> res = new ArrayList<Integer>();

        for(int i=0; i<n; i++){
            if(nums[i] <= n+1){
                check[nums[i]] = true;
            }
        }

        for(int i=1; i<n+1; i++){
            if(check[i] == false  ){
                res.add(i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int []A = {4,3,2,7,8,2,3,1};
        question448 q = new question448();
        List<Integer> res = q.findDisappearedNumbers(A);
        for(int temp:res){
            System.out.println(temp);
        }
    }
}
