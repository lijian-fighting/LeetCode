/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:55 2018/3/19
 * @Modified By:
 */
public class question168 {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    public static void main(String[] args) {
        question168 q = new question168();
        System.out.println(q.convertToTitle(37));
    }
}
