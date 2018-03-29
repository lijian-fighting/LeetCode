import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:33 2018/3/29
 * @Modified By:
 */
public class question73 {
    //Good solution //将每行每列的第一个数设置为0，以此判断是否整行整列为0
    public void setZeroes_2(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0) {
            return;
        }
        boolean isFirstRowZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for (int j = 0; j < n; j ++) {
            if (matrix[0][j] == 0) {
                isFirstRowZero = true;
            }
        }
        for (int i = 1; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        //after collecting data about which row, col needs to be set to 0, set them
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
        return;
    }

    //My solution
    public void setZeroes(int[][] matrix) {
        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[0].length;j++){
                if(matrix[i][j] == 0){
                    row.add(i);
                    col.add(j);
                }
            }
        }
        for(int r:row){
            for(int j = 0;j<matrix[0].length;j++) {
                matrix[r][j] = 0;
            }
        }
        for(int i = 0;i<matrix.length;i++){
            for(int c:col){
                matrix[i][c] = 0;
            }
        }
    }
}
