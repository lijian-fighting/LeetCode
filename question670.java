import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:56 2018/3/7
 * @Modified By:
 */
public class question670 {
    public int maximumSwap(int num) {
        //将每一位数字的索引标志为最后一次出现的位置，然后比较
        char[] A = Integer.toString(num).toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < A.length; i++) {
            last[A[i] - '0'] = i;
        }

        for (int i = 0; i < A.length; i++) {
            for (int d = 9; d > A[i] - '0'; d--) {
                if (last[d] > i) {
                    char tmp = A[i];
                    A[i] = A[last[d]];
                    A[last[d]] = tmp;
                    return Integer.valueOf(new String(A));
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        question670 q = new question670();
        System.out.println(q.maximumSwap(2637));
    }
}
