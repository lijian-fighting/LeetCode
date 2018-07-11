import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:24 2018/7/9
 * @Modified By:
 */
public class question473 {
    public boolean makesquare(int[] nums) {
        if(nums == null || nums.length < 4) {
            return false;
        }
        int sum = 0;
        for(int num:nums){
            sum = sum + num;
        }
        if(sum % 4 != 0){
            return false;
        }
        return dfs(nums,new int[4],0,sum /4);
    }
    //排序之后再dfs跑的更快
    public boolean dfs(int []nums,int []res,int index, int target){
        if(index == nums.length){
            if(res[0] == target && res[1] == target && res[2] == target){
                return true;
            }
            return false;
        }
        for(int i = 0;i<4;i++){
            if(res[i] + nums[index] > target) continue;
            res[i] = res[i] + nums[index];
            if(dfs(nums,res,index+1,target)) return true;
            res[i] = res[i] - nums[index];
        }
        return false;
    }

}
