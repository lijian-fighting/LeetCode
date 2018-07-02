import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:04 2018/7/2
 * @Modified By:
 */
public class question554 {
    public int leastBricks(List<List<Integer>> wall) {
        int height = wall.size();
        int max = 0;
        Map<Integer, Integer> record = new HashMap<>();
        for(List<Integer> list : wall){
            if(list.size() == 1) continue;
            int sum = 0;
            for(int i = 0; i < list.size()-1; i++){
                sum += list.get(i);
                int temp = record.getOrDefault(sum,0) + 1;
                record.put(sum, temp);
                max = Math.max(max, temp);
            }
        }
        return height - max;
    }

    public static void main(String[] args) {
        List<List<Integer>> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        B.add(1);
        B.add(2);
        B.add(2);
        B.add(1);
        A.add(B);
        List<Integer> C = new ArrayList<>();
        C.add(3);
        C.add(1);
        C.add(2);
        A.add(C);
        List<Integer> D = new ArrayList<>();
        D.add(1);
        D.add(3);
        D.add(2);
        A.add(D);
        List<Integer> E = new ArrayList<>();
        E.add(2);
        E.add(4);
        A.add(E);
        List<Integer> F = new ArrayList<>();
        F.add(3);
        F.add(1);
        F.add(2);
        A.add(F);
        List<Integer> G = new ArrayList<>();
        G.add(1);
        G.add(3);
        G.add(1);
        G.add(1);
        A.add(G);
        question554 q = new question554();
        System.out.println(q.leastBricks(A));

    }
}
