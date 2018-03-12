import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 8:53 2018/3/5
 * @Modified By:
 */
public class question56 {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> res = new ArrayList<>();
        if(intervals.isEmpty() || intervals.size() == 0){
            return res;
        }
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                int i = o1.start - o2.start;
                if(i == 0){
                    return o1.end - o2.end;
                }
                return i;
            }
        });
        int min = intervals.get(0).start;
        int max = intervals.get(0).end;
        for(Interval temp:intervals){
            if(temp.start > max){
                res.add(new Interval(min,max));
                min = temp.start;
                max = temp.end;
            }else{
                max = Math.max(max,temp.end);
                min = Math.min(min,temp.start);
            }
        }
        res.add(new Interval(min,max));
        return res;
    }

    public static void main(String[] args) {
        Interval a1 = new Interval(1,3);
        Interval a2 = new Interval(2,6);
        Interval a3 = new Interval(15,18);
        Interval a4 = new Interval(8,10);
        List<Interval> all = new ArrayList<>();
        all.add(a1);
        all.add(a2);
        all.add(a3);
        all.add(a4);
        question56 q = new question56();
        List<Interval> res = q.merge(all);
        for(Interval a:res){
            System.out.println(a.start+":"+a.end);
        }
    }
}
class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
