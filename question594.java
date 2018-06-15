import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:49 2018/6/15
 * @Modified By:
 */
public class question594 {
    public int findLHS(int[] nums) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        int res = 0;
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key: map.keySet()) {
            if (map.containsKey(key + 1))
                res = Math.max(res, map.get(key) + map.get(key + 1));
        }
        return res;
    }

    public static void main(String[] args) {
        int []A = {1,3,2,2,5,2,3,7};
        question594 q = new question594();
        System.out.println(q.findLHS(A));
    }
}
