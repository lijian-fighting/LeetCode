import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:44 2018/6/11
 * @Modified By:
 */
public class question387 {
    //使用map存放
    public int firstUniqChar(String s) {
        char []arr = s.toCharArray();
        Map<Character,Integer> m = new LinkedHashMap<>();
        for(char temp : arr){
            m.put(temp,m.getOrDefault(temp,0)+1);
        }
        for(Character temp : m.keySet()){
            if(m.get(temp) == 1){
                return s.indexOf(temp);
            }
        }
        return -1;
    }
    //使用两个函数 indexof 和lastindexof，判断首尾的相同字母的index是否一致
    public int firstUniqChar1(String s) {
        int resIndex = s.length();
        if(resIndex == 0)
            return -1;
        for(char c = 'a';c<='z';c++){
            int index = s.indexOf(c);
            if(index!=-1 && index == s.lastIndexOf(c)){
                resIndex = Math.min(resIndex,index);
            }
        }
        return resIndex == s.length() ? -1 : resIndex;
    }

    public static void main(String[] args) {
        String s = "leetcode";
        question387 q = new question387();
        System.out.println(q.firstUniqChar(s));
    }
}
