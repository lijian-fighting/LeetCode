/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:19 2018/6/19
 * @Modified By:
 */
public class question338 {
    //使用i&1来表示奇偶数，如果是偶数，那么就是跟他左移一位一样，因为最后一位为0，如果奇数就是加1
    public int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) {
            f[i] = f[i >> 1] + (i & 1);
        }
        return f;
    }

    public static void main(String[] args) {
        question338 q =new question338();
        int []A = q.countBits(11);
        for(int temp:A){
            System.out.println(temp);
        }
    }
}
