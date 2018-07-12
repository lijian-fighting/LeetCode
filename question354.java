import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:29 2018/7/12
 * @Modified By:
 */
public class question354 {
    public int maxEnvelopes(int[][] envelopes) {
        //数组排序
        if(envelopes == null || envelopes.length == 0
                || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
            }
        });
        int dp[] = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len++;
        }
        return len;
    }

    public static void main(String[] args) {
        int [][]A = {{4,2},{6,7},{6,4},{2,3}};
        question354 q = new question354();
        System.out.println(q.maxEnvelopes(A));
    }
}
