import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 15:38 2018/2/28
 * @Modified By:
 */
public class question39 {
    /**
     * 可以用一个计数的数组来降低开销，递归的时候只改变数组里选择的值，最后reserve=0再生成list
     * **/
    int n;
    int nums[];
    List<List<Integer>> result;
    //当前集合，当前使用的数字位置，当前还剩多少
    public void find(List<Integer> values,int index,int reserve){
        if(reserve==0){
            ArrayList<Integer> item=new ArrayList<Integer>();
            item.addAll(values);
            result.add(item);
        }
        for(int i=index;i<n;i++){
            if(nums[i]<=reserve){
                values.add(nums[i]);
                find(values,i,reserve-nums[i]);
                values.remove(values.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //排序然后去除重复的
        Arrays.sort(candidates);
        //去除重复，这样省心
        int i,n;
        n=1;
        for(i=1;i<candidates.length;i++){
            if(candidates[i]!=candidates[i-1]){
                candidates[n++]=candidates[i];
            }
        }
        this.nums=candidates;
        this.n=n;
        this.result=new ArrayList<List<Integer>>();
        find(new ArrayList<Integer>(),0,target);
        return this.result;


    }

    public static void main(String[] args) {
        int []a = new int[]{2,3,6,7};
        question39 q = new question39();
        System.out.println(q.combinationSum(a,7));
    }
}
