/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:08 2018/6/14
 * @Modified By:
 */
public class question400 {
    //定义一个长度来表示现在一个数代表几位，然后求出自己是第几个数.
    public int findNthDigit(int n) {
        int len = 1;
        long count = 9;
        int start = 1;

        while (n > len * count) {
            n -= len * count;
            len += 1;
            count *= 10;
            start *= 10;
        }

        start += (n - 1) / len;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
    public static void main(String[] args) {
        question400 q = new question400();
        System.out.println(q.findNthDigit(111));
    }
}
