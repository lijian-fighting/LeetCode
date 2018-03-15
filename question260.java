import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:13 2018/3/15
 * @Modified By:
 */
public class question260 {
    //使用异或操作//
    public int[] singleNumber(int[] nums) {
        // Pass 1 :
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        System.out.println(diff);
        // Get its last set bit
        diff &= -diff;
        System.out.println(diff);
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,2,3,1,2,5};
        question260 q = new question260();
        int []re = q.singleNumber(a);
        for(int j =0;j<re.length;j++){
            System.out.println(re[j]);
        }
    }
}
