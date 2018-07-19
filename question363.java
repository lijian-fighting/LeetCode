import java.util.TreeSet;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:45 2018/7/19
 * @Modified By:
 */
public class question363 {
    //使用二维数组 变成一维数组来操作，每次根据数组的来求和  https://www.youtube.com/watch?v=yCQN096CwWM
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int row = matrix.length;
        if(row==0)return 0;
        int col = matrix[0].length;
        int m = Math.min(row,col);
        int n = Math.max(row,col);
        //indicating sum up in every row or every column
        boolean colIsBig = col>row;
        int res = Integer.MIN_VALUE;
        for(int i = 0;i<m;i++){
            int[] array = new int[n];
            // sum from row j to row i
            for(int j = i;j>=0;j--){
                int val = 0;
                TreeSet<Integer> set = new TreeSet<Integer>();
                set.add(0);
                //traverse every column/row and sum up
                for(int index = 0;index<n;index++){
                    array[index]=array[index]+(colIsBig?matrix[j][index]:matrix[index][j]);
                    val = val + array[index];
                    //use  TreeMap to binary search previous sum to get possible result
                    Integer subres = set.ceiling(val-k);
                    if(null!=subres){
                        res=Math.max(res,val-subres);
                    }
                    set.add(val);
                }
            }
        }
        return res;

    }

    public static void main(String[] args) {
        int [][]A = {{1,0,1},{0,-2,3}};
        question363 q = new question363();
        System.out.println(q.maxSumSubmatrix(A,2));
    }
}
