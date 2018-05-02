/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:32 2018/4/23
 * @Modified By:
 */
public class question153 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int mid = (start + end) / 2;
            if(mid > 0 && nums[mid] < nums[mid - 1]){
                return nums[mid];
            }
            if(nums[start] <= nums[mid] && nums[mid] > nums[end]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return nums[start];
    }

    public static void main(String[] args) {
        question153 q = new question153();
        int []A = {2,1};
        System.out.println(q.findMin(A));
    }
}
