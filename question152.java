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
    public int maxProduct1(int[] nums) {
        int n=nums.length;
        if(n==0) return 0;
        if(n==1) return nums[0];
        int max=Integer.MIN_VALUE;
        int multi=1;
        for(int i=0;i<n;i++) {
            max=Math.max(max, multi*=nums[i]);
            if(nums[i]==0) multi=1;
        }
        multi=1;
        for(int i=n-1;i>=0;i--) {
            max=Math.max(max, multi*=nums[i]);
            if(nums[i]==0) multi=1;
        }
        return max;
    }

    public static void main(String[] args) {
        question152 q = new question152();
        int []A = {2,-2,-3,-4,5};
        System.out.println(q.maxProduct1(A));
    }
}
