/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:25 2018/5/3
 * @Modified By:
 */
public class question821 {
    public int[] shortestToChar(String S, char C) {
        int []res = new int[S.length()];
        int index = -1;
        for(int i = 0;i<S.length();i++){
            if(S.charAt(i) == C){
                index = i;
            }else if(index != -1){
                res[i] = i - index;
            }
        }
        index = -1;
        for(int i = S.length()-1;i>=0;i--){
            if(S.charAt(i) == C){
                index = i;
            }else if(index != -1){
                res[i] = res[i] == 0 ? index - i : Math.min(index - i,res[i]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String S = "loveleetcode";
        question821 q = new question821();
        int []res = q.shortestToChar(S,'e');
        System.out.println(res);
    }
}
