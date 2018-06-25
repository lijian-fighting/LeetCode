import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:10 2018/6/22
 * @Modified By:
 */
public class question390 {
    public int lastRemaining(int n) {
        return n == 1 ? 1 : 2 * (1 + n / 2 - lastRemaining(n / 2));
    }

    public static void main(String[] args) {
        question390 q = new question390();
        System.out.println(q.lastRemaining(9));
    }
}
