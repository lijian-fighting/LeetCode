/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 13:50 2018/2/28
 * @Modified By:
 */
public class question283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int []nums = new int[]{0,1,0,3,12};
        question283 q = new question283();
        q.moveZeroes(nums);
        for(int i = 0;i<nums.length;i++) {
            System.out.println(nums[i]);
        }
    }
}
