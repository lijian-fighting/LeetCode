import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:19 2018/3/13
 * @Modified By:
 */
public class question540 {
    public int singleNonDuplicate(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return nums[0];
        int result = nums[0];
        int count = 1;
        for(int i=1; i<len; i++) {
            if(nums[i] == result)
                count++;
            else if(count == 1)
                break;
            else {
                result = nums[i];
                count = 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,1,2};
        question540 q = new question540();
        System.out.println(q.singleNonDuplicate(a));
    }
}
