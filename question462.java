import java.util.Arrays;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:19 2018/3/12
 * @Modified By:
 */
public class question462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int key = nums[nums.length / 2];
        int max = 0;
        for(int i = 0;i<nums.length;i++){
            max = max + Math.abs(key - nums[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,2,3};
        question462 q = new question462();
        System.out.println(q.minMoves2(a));
    }
}
