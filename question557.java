import java.util.Calendar;
import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 16:26 2018/3/7
 * @Modified By:
 */
public class question557 {
    //转化维数组就行了//字符串到数组的转化
    public String reverseWords(String s) {
        if(s == null || s.length() ==0){
            return s;
        }
        char[] str = s.toCharArray();
        int start = 0;
        for(int i = 0; i< str.length ; i++){
            if(str[i]==' '){
                reverse(start,i-1,str);
                start = i+1;
            }
        }
        reverse(start, str.length-1,str );
        return String.valueOf(str);

    }

    //reverse function
    public void reverse(int start, int end, char[]str){
        while(start < end){
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start ++;
            end --;
        }
    }


    public static void main(String[] args) {
        question557 q = new question557();
        System.out.println(q.reverseWords("wo ai ni"));
    }
}
