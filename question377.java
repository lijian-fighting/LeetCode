import java.util.Arrays;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:49 2018/3/16
 * @Modified By:
 */
public class question377 {
    public int combinationSum4(int[] nums, int target) {
        int[] comb = new int[target + 1];
        comb[0] = 1;
        for (int i = 1; i < comb.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    comb[i] += comb[i - nums[j]];
                }
            }
        }
        return comb[target];
    }

    public static void main(String[] args) {
        int []num = {1,2,3};
        question377 q =new question377();
        System.out.println(q.combinationSum4(num,4));
    }
}
