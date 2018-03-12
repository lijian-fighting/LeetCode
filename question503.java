/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:51 2018/3/2
 * @Modified By:
 */
public class question503 {
    public int[] nextGreaterElements(int[] nums) {
        int []res = new int[nums.length];
        int index = 0;
        for(int i = 0;i<nums.length;i++){
            for(int j = i;;){
                if(j == nums.length-1){
                    j = 0;
                }else{
                    j++;
                }
                if(nums[j] > nums[i]){
                    res[index++] = nums[j];
                    break;
                }
                if(j == i){
                    res[index++] = -1;
                    break;
                }

            }

        }
        return res;
    }

    public static void main(String[] args) {
        int []a = new int[]{1,2,1};
        question503 q = new question503();
        int []b = q.nextGreaterElements(a);
        for(int res:b){
            System.out.println(res);
        }
    }
}
