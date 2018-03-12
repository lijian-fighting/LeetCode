import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:03 2018/3/11
 * @Modified By:
 */
public class question560 {
    //sum[i] - sum[j] = k, i --- j之间的和为k
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        HashMap< Integer, Integer > map = new HashMap < > ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,1,1};
        question560 q =new question560();
        System.out.println(q.subarraySum(a,2));
    }
}
