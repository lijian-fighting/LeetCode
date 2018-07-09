import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 8:59 2018/7/9
 * @Modified By:
 */
public class question47 {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int[] visited = new int[num.length];
        Arrays.sort(num);
        helper(result, list, visited, num);
        return result;
    }
    //注意一些相同的值需要跳过
    public void helper(List<List<Integer>> result, List<Integer> list, int[] visited, int[] num) {
        if(list.size() == num.length)
            result.add(new ArrayList<Integer>(list));
        for(int i = 0; i < num.length; i++) {
            if (visited[i] == 1 || (i != 0 && num[i] == num[i - 1] && visited[i - 1] == 0))
                continue;
            visited[i] = 1;
            list.add(num[i]);
            helper(result, list, visited, num);
            list.remove(list.size() - 1);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        int []A = {1,2,3,4};
        for(int []B:Arrays.asList(A)
    }
}
