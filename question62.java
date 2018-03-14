/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:49 2018/3/14
 * @Modified By:
 */
public class question62 {
    //上方和左方永远为1，只能向下和向右
    public int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    public static void main(String[] args) {
        question62 q = new question62();
        System.out.println(q.uniquePaths(3,7));
    }
}
