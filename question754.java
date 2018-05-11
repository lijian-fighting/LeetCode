/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:21 2018/5/11
 * @Modified By:
 */
public class question754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = 0;
        int sum = 0;
        while (sum < target) {
            step++;
            sum += step;
        }
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    public static void main(String[] args) {
        question754 q = new question754();
        System.out.println(q.reachNumber(3));
    }
}
