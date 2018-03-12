/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:38 2018/3/1
 * @Modified By:
 */
public class question201 {
    public int rangeBitwiseAnd(int m, int n) {
        int step = 0;
        while(m!=n){
            m >>= 1;
            n >>= 1;
            step ++;
        }
        return m<<step;
    }

    public static void main(String[] args) {
        question201 q = new question201();
        System.out.println(q.rangeBitwiseAnd(5,7));
    }
}
