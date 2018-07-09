/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:52 2018/7/6
 * @Modified By:
 */
public class question780 {
    //从后往前，通过计算差来加快递归
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx == tx && sy == ty) {
            return true;
        } else if (tx == ty || sx > tx || sy > ty) {
            return false;
        } else if (tx > ty) {
            int subtract = Math.max(1, (tx - sx)/ty);
            return reachingPoints(sx, sy, tx - subtract * ty, ty);
        } else {
            int subtract = Math.max(1, (ty - sy)/tx);
            return reachingPoints(sx, sy, tx, ty - subtract * tx);
        }
    }
}
