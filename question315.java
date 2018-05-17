import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:52 2018/5/16
 * @Modified By:
 */
public class question315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length == 0){
            return res;
        }
        res.add(0);

        for(int i = nums.length-2;i>=0;i--){
            int temp = nums[i];
            for(int j = i + 1;;j++){
                if(j == nums.length || temp <= nums[j]){
                    nums[j-1] = temp;
                    res.add(j-i-1);
                    break;
                }else{
                    nums[j-1] = nums[j];
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        question315 q = new question315();
        int []A = {5,2,6,1};
        List<Integer> temp = q.countSmaller(A);
        for(int a : temp){
            System.out.println(a);
        }
    }
}
