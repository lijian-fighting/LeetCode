import java.util.Arrays;
import java.util.TreeMap;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:14 2018/7/11
 * @Modified By:
 */
public class question846 {
    public boolean isNStraightHand(int[] hand, int W) {
        TreeMap<Integer, Integer> count = new TreeMap();
        for (int card: hand) {
            if (!count.containsKey(card))
                count.put(card, 1);
            else
                count.replace(card, count.get(card) + 1);
        }

        while (count.size() > 0) {
            int first = count.firstKey();
            for (int card = first; card < first + W; ++card) {
                if (!count.containsKey(card)) return false;
                int c = count.get(card);
                if (c == 1) count.remove(card);
                else count.replace(card, c - 1);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int []A = {1,1,2,2,3,3};
        question846 q = new question846();
        System.out.println(q.isNStraightHand(A,2));
    }
}
