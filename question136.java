/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:00 2018/6/8
 * @Modified By:
 */
public class question136 {
    public int singleNumber(int[] nums) {
        int res = nums[0];
        for(int i = 1;i<nums.length;i++){
            res = res^nums[i];
        }
        return res;
    }
}
