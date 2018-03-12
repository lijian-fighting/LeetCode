/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:56 2018/3/8
 * @Modified By:
 */
public class question55 {
    public boolean canJump(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }

}
