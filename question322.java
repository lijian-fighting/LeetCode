import java.util.Arrays;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:55 2018/3/5
 * @Modified By:
 */
public class question322 {
    //动态规划，使用数组存储中间结果变量。
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        int []a = new int[]{1,2,5};
        question322 q = new question322();
        System.out.println(q.coinChange(a,11));
    }
}
