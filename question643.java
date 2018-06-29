/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:26 2018/6/29
 * @Modified By:
 */
public class question643 {
    public double findMaxAverage(int[] nums, int k) {
        int []dp = new int[nums.length-k+1];
        for(int i = 0;i<k;i++){
            dp[0] += nums[i];
        }
        int max = dp[0];
        for(int i = 1;i<dp.length;i++){
           dp[i] = dp[i-1]+nums[i+k-1]-nums[i-1];
            if(dp[i] > max){
                max = dp[i];
            }
        }
        return (double)max / k;
    }
    public double findMaxAverage1(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++)
            sum+=nums[i];
        double res=sum;
        for(int i=k;i<nums.length;i++){
            sum+=nums[i]-nums[i-k];
            res=Math.max(res,sum);
        }
        return res/k;
    }
    public static void main(String[] args) {
        int []A = {1,12,-5,-6,50,3};
        question643 q= new question643();
        System.out.println(q.findMaxAverage(A,4));
    }
}
