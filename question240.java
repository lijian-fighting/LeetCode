import java.util.Queue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:18 2018/3/1
 * @Modified By:
 */
public class question240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        //从右上角开始判断。
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(col >= 0 && row <= matrix.length-1) {
            if(target == matrix[row][col]) {
                return true;
            } else if(target < matrix[row][col]) {
                col--;
            } else if(target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        question240 q = new question240();
        System.out.println(q.searchMatrix(new int[1][1], 0));
    }
}
