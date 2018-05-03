import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:46 2018/5/3
 * @Modified By:
 */
public class question290 {
    public boolean wordPattern(String pattern, String str) {
        char []pat = pattern.toCharArray();
        String []s = str.split(" ");
        if(pat.length != s.length){
            return false;
        }
        Map<String,Character> res = new HashMap<>();
        for(int i = 0;i<pat.length;i++){
            if(res.containsKey(s[i])){
                if(res.get(s[i]) != pat[i]){
                    return false;
                }
            }else{
                if(res.containsValue(pat[i])){
                    return false;
                }
                res.put(s[i],pat[i]);
            }
        }
        return true;
    }
}
