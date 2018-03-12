/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:19 2018/2/28
 * @Modified By:
 */
public class question476 {
    public int findComplement(int num) {
        int res = 0;
        int origin = num;
        while(num != 0){
            num = num /2;
            res = res + 1;
        }
        return (int)(Math.pow(2,res) - origin - 1);
    }

    public static void main(String[] args) {
        question476 q = new question476();
        System.out.println(q.findComplement(1));
    }
}
