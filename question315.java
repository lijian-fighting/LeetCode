import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:52 2018/5/16
 * @Modified By:
 */
public class question315 {
    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 0)
            return new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for(int value : nums)
        {
            if(value < min)
                min = value;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] - min + 1;
        }
        int max = Integer.MIN_VALUE;
        for(int value : nums) {
            if(value > max)
                max = value;
        }
        int[] BITree = new int[max + 1];
        BITree[0] = 0;
        int[] countArr = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int count = getSum(nums[i]-1, BITree);
            countArr[i] = count;
            update(nums[i], BITree);
        }
        List<Integer> result = new ArrayList<>();
        for(int value : countArr) {
            result.add(value);
        }
        return result;
    }
    public int getSum(int value, int[] BITree) {
        int sum = 0;
        while(value > 0) {
            sum += BITree[value];
            //System.out.println("BITree[" + value + "] = " + BITree[value] + " sum  = " + sum);
            value -= (value & -value);
        }
        return sum;
    }
    public void update(int value, int[] BITree) {
        while(value <= BITree.length - 1) {
            BITree[value] += 1;
            //System.out.println("BITree[" + value + "] = " + BITree[value]);
            value += (value & -value);
        }
    }
    public static void main(String[] args) {
        question315 q = new question315();
        int []A = {5,2,6,1};
        List<Integer> temp = q.countSmaller(A);
        for(int a : temp){
            System.out.println(a);
        }
    }
}
