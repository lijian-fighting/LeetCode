/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:37 2018/4/26
 * @Modified By:
 */
public class question403 {
    public boolean canCross(int[] stones) {
        int step = 0;
        if(stones == null || stones.length <= 1){
            return false;
        }
        boolean []dp = new boolean[stones.length];
        dp[0] = true;
        for(int i = 1;i<stones.length;i++){
            for(int j = 0)
            if(dp[i-1] && Math.abs(stones[i] - stones[i-1] - step) <= 1){
                step = stones[i] - stones[i-1];
                dp[i] = true;
            }
        }
        return dp[stones.length-1];
    }
}
