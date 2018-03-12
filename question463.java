import java.sql.Array;
import java.util.Arrays;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:11 2018/3/9
 * @Modified By:
 */
public class question463 {
    //顺序遍历，左上往右下，所以只要考虑右下
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}
