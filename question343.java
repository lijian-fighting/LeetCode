/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:42 2018/7/5
 * @Modified By:
 */
public class question343 {
    public int integerBreak(int n) {
        int []dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3;i<=n;i++){
            for(int j = 1;j<i;j++) {
                dp[i] = Math.max(dp[i],j*dp[i-j]);
                dp[i] = Math.max(dp[i],j*(i-j));
            }
        }
        return dp[n];

    }


    public int integerBreak1(int n) {

        if(n==2)    return 1;
        if(n==3)    return 2;

        int prod =1;
        while(n>4) {

            prod *= 3;
            n -= 3;
        }
        prod *= n;
        return prod;
    }
}
