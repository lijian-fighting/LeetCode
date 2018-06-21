/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 12:32 2018/6/20
 * @Modified By:
 */
public class question36 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] colChecker= new boolean[9][9];
        boolean [][] boxChecker = new boolean[9][9];
        for(int row=0; row<9;++row){
            boolean[] rowChecker = new boolean[9];
            for(int col=0; col<9;++col){
                if(board[row][col]!='.'){
                    char check = board[row][col];
                    int idx=(int)check-'1';
                    int boxNumb=mapToBox(row,col);
                    if(colChecker[col][idx]||rowChecker[idx]||boxChecker[boxNumb][idx]){
                        return false;
                    }
                    colChecker[col][idx]=true;
                    rowChecker[idx]=true;
                    boxChecker[boxNumb][idx]=true;
                }
            }
        }
        return true;
    }


    public int mapToBox(int row, int col){
        return col/3+3*(row/3);
    }
}
