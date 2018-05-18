import java.util.HashMap;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:21 2018/5/18
 * @Modified By:
 */
public class question76 {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0){
            return "";
        }
        Map<Character,Integer> res = new HashMap<Character,Integer>();
        for(int i = 0;i<t.length();i++){
            res.put(t.charAt(i),res.getOrDefault(t.charAt(i),0)+1);
        }
        int left = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        for(int right = 0;right < s.length();right++){
            if(res.containsKey(s.charAt(right))){
                res.put(s.charAt(right),res.get(s.charAt(right))-1);
                if(res.get(s.charAt(right))>=0){
                    count++;
                }
                while(count == t.length()){
                    if(right - left + 1 < minLen){
                        minLen = right - left + 1;
                        minStart = left;
                    }
                    if(res.containsKey(s.charAt(left)))
                    {
                        res.put(s.charAt(left), res.get(s.charAt(left))+1);
                        //这一步的作用是确定这个删除不会影响下面的判断。
                        if(res.get(s.charAt(left))>0)
                        {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if(minLen>s.length())
        {
            return "";
        }
        return s.substring(minStart,minStart+minLen);
    }

    public static void main(String[] args) {
        question76 q = new question76();
        q.minWindow("ABBBCBBA","ABBC");
    }
}
