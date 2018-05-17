import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:39 2018/5/17
 * @Modified By:
 */
public class question677 {
    Map<String, Integer> map;
    Map<String, Integer> score;
    public question677() {
        map = new HashMap();
        score = new HashMap();
    }
    public void insert(String key, int val) {
        int delta = val - map.getOrDefault(key, 0);
        map.put(key, val);
        String prefix = "";
        for (char c: key.toCharArray()) {
            prefix += c;
            score.put(prefix, score.getOrDefault(prefix, 0) + delta);
        }
    }
    public int sum(String prefix) {
        return score.getOrDefault(prefix, 0);
    }
}
