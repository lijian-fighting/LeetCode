/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:55 2018/3/6
 * @Modified By:
 */
public class question583 {
    public int minDistance(String word1, String word2) {
        int[] dp = new int[word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            int[] temp=new int[word2.length()+1];
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    temp[j] = i + j;
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    temp[j] = dp[j - 1];
                else
                    temp[j] = 1 + Math.min(dp[j], temp[j - 1]);
            }
            dp=temp;
        }
        return dp[word2.length()];
    }

    public static void main(String[] args) {
        String a = "sea";
        String b = "eat";
        question583 q = new question583();
        System.out.println(q.minDistance(a,b));
    }
}
