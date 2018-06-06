/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:28 2018/6/5
 * @Modified By:
 */
public class question64 {
    public int minPathSum(int[][] grid) {
        int [][]dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i<dp[0].length;i++){
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }
        for(int i = 1;i<dp.length;i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int i = 1;i<dp.length;i++){
            for(int j = 1;j<dp[0].length;j++){
                dp[i][j] = Math.min(dp[i-1][j]+grid[i][j],dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
    public int minPathSum1(int[][] grid) {
        /**recursion memorization**/
        int m = grid.length;
        int n = grid[0].length;
        int[][]memo = new int[m][n];
        int x=m;
        int y=n;
        return dfs(grid,x-1,y-1,memo);
    }

    public int dfs(int[][]grid,int x,int y,int[][]memo)
    {
        if(x<0 || y<0)
            return Integer.MAX_VALUE;
        if(memo[x][y] > 0)
            return memo[x][y];

        if(x==0 && y==0)
            return grid[0][0];


        int ans = grid[x][y] + Math.min(dfs(grid,x-1,y,memo),dfs(grid,x,y-1,memo));
        memo[x][y]=ans;

        return ans;
    }
}
