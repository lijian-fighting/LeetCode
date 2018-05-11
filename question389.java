/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:09 2018/5/11
 * @Modified By:
 */
public class question389 {
    public char findTheDifference(String s, String t) {
        int a = 0;
        for(int i = 0;i<s.length();i++){
            a = a ^ (s.charAt(i) - 'a');
        }
        for(int i = 0;i<t.length();i++){
            a = a ^ (t.charAt(i) - 'a');
        }
        return (char)(a + 'a');
    }

    public static void main(String[] args) {
        question389 q = new question389();
        System.out.println(q.findTheDifference("abcd","abcde"));
    }
}
