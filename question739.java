import java.util.Stack;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:44 2018/3/7
 * @Modified By:
 */
public class question739 {
    //巧妙地使用栈这个数据结构
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> stack = new Stack();
        for (int i = temperatures.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) stack.pop();
            ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);
        }
        return ans;
    }
}
