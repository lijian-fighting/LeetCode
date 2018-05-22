/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:55 2018/5/22
 * @Modified By:
 */
public class question486 {
    //通过player1为加，player2为减法
    public boolean PredictTheWinner(int[] nums) {
        return winner(0,nums.length-1,nums,1) >= 0;
    }
    private int winner(int start,int end,int []nums,int turn){
        if(start == end){
            return turn*nums[start];
        }
        int a = turn*nums[start] + winner(start+1,end,nums,-turn);
        int b = turn*nums[end] + winner(start,end-1,nums,-turn);
        return turn * Math.max(turn * a, turn * b);
    }

    //we can easily determine the maximum effective score possible for the subarray nums[x,y]nums[x,y]
    // as max(nums[x]−score[x+1,y],nums[y]−score[x,y−1])
    public boolean PredictTheWinner1(int[] nums) {
        int[][] dp = new int[nums.length + 1][nums.length];
        for (int s = nums.length; s >= 0; s--) {
            for (int e = s + 1; e < nums.length; e++) {
                int a = nums[s] - dp[s + 1][e];
                int b = nums[e] - dp[s][e - 1];
                dp[s][e] = Math.max(a, b);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        question486 q = new question486();
        int []A = {1,5,2,4,6};
        System.out.println(q.PredictTheWinner1(A));
    }
}
