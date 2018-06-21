import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:44 2018/6/21
 * @Modified By:
 */
public class question217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(res.containsKey(nums[i])){
                return true;
            }else{
                res.put(nums[i],1);
            }
        }
        return false;
    }
    public boolean containsDuplicate1cd(int[] nums) {
        if(nums == null || nums.length == 1) return false;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num : nums){
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }

        boolean[] bool = new boolean[max - min + 1];
        for(int num : nums){
            if(bool[num - min])
                return true;
            else
                bool[num - min] = true;
        }

        return false;

    }
}
