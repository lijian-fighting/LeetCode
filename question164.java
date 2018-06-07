import java.util.Arrays;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:49 2018/6/7
 * @Modified By:
 */
public class question164 {
    public int maximumGap(int[] nums) {
        if(nums.length < 2){
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for(int i = 0;i<nums.length-1;i++){
            max = Math.max(max,nums[i+1]-nums[i]);
        }
        return max;
    }
    public int maximumGap1(int[] nums) {
        int size = nums.length;
        if (size < 2) return 0;

        int max = -1;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            // min = Math.min(min, i);
            // max = Math.max(max, i);
            if (i < min) min = i;
            if (i > max) max = i;
        }

        int bucketSize = (max - min) / size;
        if (bucketSize == 0) bucketSize = 1;

        int bucketNumber = (max - min) / bucketSize + 1;
        int[] bucketMin = new int[bucketNumber];
        int[] bucketMax = new int[bucketNumber];

        for (int i = 0; i < bucketNumber; i ++) {
            bucketMin[i] = Integer.MAX_VALUE;
            bucketMax[i] = -1;
        }

        for (int i: nums) {
            int k = (i - min) / bucketSize;
            if (i < bucketMin[k]) bucketMin[k] = i;
            if (i > bucketMax[k]) bucketMax[k] = i;
        }
        //radix sort
        int maxGap = 0;
        int pre = bucketMax[0];
        for (int i = 1; i < bucketNumber; i ++) {
            if (bucketMax[i] == -1) continue;
            int tmp = bucketMin[i] - pre;
            if (tmp > maxGap) maxGap = tmp;
            pre = bucketMax[i];
        }
        return maxGap;

    }
}
