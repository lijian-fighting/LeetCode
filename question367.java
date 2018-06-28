/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:29 2018/6/28
 * @Modified By:
 */
public class question367 {
    public boolean isPerfectSquare(int num) {
        if( (num % 10 != 1) && (num % 10 != 4) && (num % 10 != 9) && (num % 10 != 6) && (num % 10 != 5) && (num % 100 != 0)){
            return false;
        }
        for(int i =1;;i++){
            if(i*i == num){
                return true;
            }
            if(i*i > num){
                break;
            }
        }
        return false;
    }
    public boolean isPerfectSquare1(int num){

        if(num <= 0) return false;

        int left = 1, right = num;

        while(left <= right){
            int mid = left + (right - left)/2;
            // use "/" to avoid overflow
            if(mid > num / mid){
                right = mid - 1;
            }else if(mid < num / mid){
                left = mid + 1;
            }else{
                return num % mid == 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        question367 q = new question367();
        System.out.println(q.isPerfectSquare(16));
    }
}
