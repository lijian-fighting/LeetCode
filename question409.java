import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:51 2018/6/27
 * @Modified By:
 */
public class question409 {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c: s.toCharArray())
            count[c]++;

        int ans = 0;
        for (int v: count) {
            ans += v / 2 * 2;
            if (ans % 2 == 0 && v % 2 == 1)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        question409 q = new question409();
        System.out.println(q.longestPalindrome("AAAABB"));
    }
}
