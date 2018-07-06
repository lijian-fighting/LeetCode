import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:06 2018/7/6
 * @Modified By:
 */
public class question547 {
    public int findCircleNum(int[][] M) {
        int count = 0;
        Set<Integer> res = new HashSet<>();
        for(int i = 0;i<M.length;i++){
            if(!res.contains(i)){
                count++;
                dfs(M,i,res);
            }
        }
        return count;
    }
    private void dfs(int[][] M, int i, Set<Integer> set) {
        if(set.contains(i)){
            return;
        }
        set.add(i);
        for(int j = 0;j<M.length;j++){
            if(M[i][j] == 1 && !set.contains(j)){
                M[i][j] = 0;
                dfs(M,j,set);
            }
        }
    }

    public static void main(String[] args) {
        int [][]M= {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        question547 q = new question547();
        System.out.println(q.findCircleNum(M));
    }
}
