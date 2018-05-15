/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:46 2018/5/15
 * @Modified By:
 */
public class question650 {
    public int minSteps(int n) {
        int ans = 0,d = 2;
        while(n>1){
            while(n%d==0){
                ans = ans + d;
                n = n / d;
            }
            d++;
        }
        return ans;
    }

    public static void main(String[] args) {
        question650 q = new question650();
        System.out.println(q.minSteps(9));
    }
}
