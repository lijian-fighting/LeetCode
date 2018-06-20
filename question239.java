import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:17 2018/6/20
 * @Modified By:
 */
public class question239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k==0) return new int[0];

        //restore the index in deque and keep the index sorted by nums[index] in the deque where the max is at head.
        Deque<Integer> Index = new ArrayDeque<Integer>();
        int[] res = new int[nums.length - k + 1];

        for (int i=0; i<nums.length; i++) {

            //remove the previous item at tail which is smaller than new one, because it cannot be the max in any case for the window.
            while(!Index.isEmpty() && nums[i] >= nums[Index.peekLast()]) Index.removeLast();

            //push the new one in the deque at tail
            Index.addLast(i);

            //remove the old item at head which is out of range, because the one at head is the max we need.
            while(Index.peekFirst()<i-k+1) Index.removeFirst();

            //put the head on in res


            if(i>=k-1) res[i-k+1] = nums[Index.peekFirst()];

        }

        return res;
    }

    public static void main(String[] args) {
        question239 q = new question239();
        int []nums = {1,3,-1,-3,5,3,6,7};
        int []A = q.maxSlidingWindow(nums,3);
        for(int temp:A){
            System.out.println(temp);
        }
    }
}
