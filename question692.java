import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:02 2018/4/23
 * @Modified By:
 */
public class question692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> count = new HashMap();
        for (String word: words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        List<String> candidates = new ArrayList(count.keySet());
        Collections.sort(candidates, (w1, w2) -> count.get(w1) != count.get(w2) ?
                count.get(w2) - count.get(w1) : w1.compareTo(w2));

        return candidates.subList(0, k);
    }

    public static void main(String[] args) {
        String []words = {"i", "love", "leetcode", "i", "love", "coding"};
        int k = 2;
        question692 q = new question692();
        List<String> tt = q.topKFrequent(words,k);
        for(String temp:tt){
            System.out.println(temp);
        }
    }
}
