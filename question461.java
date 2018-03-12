/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:36 2018/3/5
 * @Modified By:
 */
public class question461 {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
