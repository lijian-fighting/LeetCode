/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:39 2018/7/5
 * @Modified By:
 */
public class question397 {
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32; //n = 2^31-1;
        int count = 0;
        while (n > 1){
            if (n % 2 == 0) n  /= 2;
            else{
                if ( (n + 1) % 4 == 0 && (n - 1 != 2) ) n++;
                else n--;
            }
            count++;
        }
        return count;
    }
}
