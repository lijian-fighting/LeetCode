import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 11:05 2018/4/16
 * @Modified By:
 */
public class question728 {
    private static boolean isSelfDividing(int i){
        int temp = i;
        while(temp!=0){
            int a = temp % 10;
            temp = temp / 10;
            if(a == 0 || i % a != 0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for(int i = left;i<=right;i++){
            if(isSelfDividing(i)){
                res.add(i);
            }
        }
        return res;
    }
}
