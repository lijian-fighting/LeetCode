/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:26 2018/4/23
 * @Modified By:
 */
public class question41 {
    public int firstMissingPositive(int[] A) {
        int i = 0;
        while(i < A.length){
            if(A[i] == i+1 || A[i] <= 0 || A[i] > A.length) i++;
            else if(A[A[i]-1] != A[i]) swap(A, i, A[i]-1);
            else i++;
        }
        i = 0;
        while(i < A.length && A[i] == i+1) i++;
        return i+1;
    }

    private void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void main(String[] args) {
        question41 q = new question41();
        int []A = {7,8,9,11};
        System.out.println(q.firstMissingPositive(A));
    }
}
