import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:29 2018/6/19
 * @Modified By:
 */
public class question542 {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return matrix;
        final int M = matrix.length, N = matrix[0].length;
        int[][] res = new int[M][N];
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(matrix[i][j]!=0) {
                    int left = Integer.MAX_VALUE, up = Integer.MAX_VALUE;
                    if(i>0) up = res[i-1][j];
                    if(j>0) left = res[i][j-1];
                    int dist = Math.min(left, up);
                    if(dist == Integer.MAX_VALUE) res[i][j] = dist;
                    else res[i][j] = dist + 1;
                }
            }
        }

        for(int i=M-1; i>=0; i--){
            for(int j=N-1; j>=0; j--){
                if(matrix[i][j]!=0) {
                    int right = Integer.MAX_VALUE, down = Integer.MAX_VALUE;
                    if(i<M-1) down = res[i+1][j];
                    if(j<N-1) right = res[i][j+1];
                    int dist = Math.min(right, down);
                    if(dist == Integer.MAX_VALUE) res[i][j] = Math.min(res[i][j], dist);
                    else res[i][j] = Math.min(res[i][j], dist + 1);
                }
            }
        }
        return res;

    }
}
