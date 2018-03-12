/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:03 2018/2/26
 * @Modified By:
 */
public class question42 {
    public int trap(int[] height) {
        if (height.length == 0){
            return 0;
        }
        int ans = 0;
        int []left_max = new int[height.length];
        int []right_max = new int[height.length];
        left_max[0] = height[0];
        for(int i = 1;i < height.length;i++){
            left_max[i] = Math.max(left_max[i-1],height[i]);
        }
        right_max[height.length-1] = height[height.length-1];
        for(int i = height.length-2;i>=0;i--){
            right_max[i] = Math.max(right_max[i+1],height[i]);
        }
        for(int i = 1;i<height.length;i++){
            ans += Math.min(right_max[i],left_max[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int []height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        question42 q = new question42();
        System.out.println(q.trap(height));
    }
}
