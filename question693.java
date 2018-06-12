/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:29 2018/6/12
 * @Modified By:
 */
public class question693 {
    public boolean hasAlternatingBits(int n) {
        int start = 1;
        boolean flag = true;
        while(start <= n && start >= 0){
            if(start == n){
                return true;
            }
            if(flag){
                start = start * 2;
                flag = false;
            }else {
                start = start * 2 + 1;
                flag = true;
            }
        }
        return false;
    }

    //取最后一位，并且判断是否为1或者为0
    public boolean hasAlternatingBits1(int n) {
        int last = n & 1;
        while(n!=0 && (n & 1) == last){
            last = 1 - last;
            n >>= 1;
        }
        return n == 0;
    }
    public static void main(String[] args) {
        question693 q = new question693();
        System.out.println(q.hasAlternatingBits1(10));
    }
}
