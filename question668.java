import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:59 2018/6/28
 * @Modified By:
 */
public class question668 {
    //判断数量是否足够k个
    public boolean enough(int x, int m, int n, int k) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(x / i, n);
        }
        return count >= k;
    }

    public int findKthNumber(int m, int n, int k) {
        int lo = 1, hi = m * n;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (!enough(mi, m, n, k)) lo = mi + 1;
            else hi = mi;
        }
        return lo;
    }

    public static void main(String[] args) {
        question668 q = new question668();
        System.out.println(q.findKthNumber(3,3,5));
    }
}
