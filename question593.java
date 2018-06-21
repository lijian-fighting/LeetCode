import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:54 2018/6/21
 * @Modified By:
 */
public class question593 {
    private int dist_pow(int []x,int []y){
        return (y[0]-x[0]) * (y[0] - x[0]) + (y[1]-x[1])*(y[1]-x[1]);
    }
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int dist = Integer.MIN_VALUE;
        int []max = null;
        int []ne1 = null;
        int []ne2 = null;
        if(dist_pow(p1,p2) > dist){
            dist = dist_pow(p1,p2);
            ne1 = p3;
            ne2 = p4;
            max = p2;
        }
        if(dist_pow(p1,p3) > dist){
            dist = dist_pow(p1,p3);
            ne1 = p2;
            ne2 = p4;
            max = p3;
        }
        if(dist_pow(p1,p4) > dist){
            dist = dist_pow(p1,p4);
            ne1 = p2;
            ne2 = p3;
            max = p4;
        }
        return dist_pow(p1,max) == 2* dist_pow(p1,ne1) && dist_pow(p1,ne1) == dist_pow(p1,ne2) && dist_pow(p1,ne1) != 0
                && dist_pow(ne1,max) == dist_pow(p1,ne1) && dist_pow(ne2,max) == dist_pow(p1,ne2);

    }

    private double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
    private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1,p2) > 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }
    public boolean validSquare1(int[] p1, int[] p2, int[] p3, int[] p4) {
        return check(p1, p2, p3, p4) || check(p1, p3, p2, p4) || check(p1, p2, p4, p3);
    }
}
