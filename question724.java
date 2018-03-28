import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:06 2018/3/28
 * @Modified By:
 */
public class question724 {
    public int pivotIndex_2(int[] nums) {
        int sum = 0, left = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) {
                left += nums[i - 1];
            }
            if (sum - left - nums[i] == left) {
                return i;
            }
        }
        return -1;
    }
    public int pivotIndex(int[] nums) {
        if(nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }
        int sum = 0;
        for(int i = 0 ; i< nums.length;i++){
            sum = sum + nums[i];
        }
        int res = 0;
        for(int i = 0;i<nums.length;i++){
            if(res*2 == sum -nums[i]){
                return i;
            }else {
                res = res + nums[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        question724 q = new question724();
        int []N = new int[]{1,7,3,6,5,6};
        System.out.println(q.pivotIndex(N));
    }
}
