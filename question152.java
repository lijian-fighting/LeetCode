/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:28 2018/6/8
 * @Modified By:
 */
public class question152 {
    public int maxProduct(int[] nums) {
        int max = 1;
        int min = 1;
        int ans = Integer.MIN_VALUE;

        for(int n : nums){
            if (n == 0){
                max = 1;
                min = 1;
                ans = Math.max(ans, 0);
                continue;
            }
            int premax = max;
            max = Math.max(min*n, Math.max(max*n, n));
            min = Math.min(min*n, Math.min(premax*n, n));
            ans = Math.max(ans, max);
        }

        return ans;
    }
}
