import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:36 2018/5/17
 * @Modified By:
 */
public class question830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> range = new ArrayList<>();
        char []res = S.toCharArray();
        int start = 0;
        while(start <= res.length -1){
            int end = start+1;
            while( end <= res.length - 1 && res[start] == res[end]){
                end = end + 1;
            }
            if(end -start >= 3){
                List<Integer> temp = new ArrayList<>();
                temp.add(start);
                temp.add(end-1);
                range.add(temp);
            }
            start = end;
        }
        return range;
    }

    public static void main(String[] args) {
        question830 q = new question830();
        q.largeGroupPositions("abbxxxxzzy");
    }
}
