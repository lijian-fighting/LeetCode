import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:37 2018/5/11
 * @Modified By:
 */
public class question539 {
    public int findMinDifference(List<String> timePoints) {
        List<Integer> timetoint = new ArrayList<>();
        for(String temp:timePoints){
            String []s = temp.split(":");
            if(s[0].equals("00") && s[1].equals("00")) {
                timetoint.add(24*60);
            }else {
                int time = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
                timetoint.add(time);
                timetoint.add(24 * 60 + time);
            }
        }
        Collections.sort(timetoint);
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<timetoint.size()-1;i++){
            if(timetoint.get(i+1) - timetoint.get(i) <= min){
                min = timetoint.get(i+1) - timetoint.get(i);
            }
        }
        return min;
    }
}
