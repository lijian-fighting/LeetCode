/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:56 2018/3/2
 * @Modified By:
 */
public class question520 {
    public int findTargetSumWays(int[] nums, int s) {
        int sum = 0;
        for (int n : nums)
            sum += n;
        return sum < s || (s + sum) % 2 > 0 ? 0 : subsetSum(nums, (s + sum) >>> 1);
    }

    public int subsetSum(int[] nums, int s) {
        int[] dp = new int[s + 1];
        dp[0] = 1;
        for (int n : nums)
            for (int i = s; i >= n; i--)
                dp[i] += dp[i - n];
        return dp[s];
    }


    public static void main(String[] args) {
        int []a = new int[]{1,2,3,4,5};
        question520 q = new question520();
        System.out.println(q.findTargetSumWays(a,3));
    }
}
