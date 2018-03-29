import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 10:13 2018/3/29
 * @Modified By:
 */
public class question347 {
    //good solution 通过最大值和最小值来建立对应数组,通过计数排序来解决这个问题。
    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<Integer> ();
        int min = nums[0];
        int max = nums[0];
        for(int n : nums){
            min = min < n ? min : n;
            max = max > n ? max : n;
        }
        int[] data = new int[max - min + 1];
        for(int n : nums) {
            data[n - min] ++;
        }
        List[] bucket = new List[nums.length + 1];
        for(int i = data.length -1 ; i >= 0; i --){
            if(data[i] > 0){
                if(bucket[data[i]] == null)
                    bucket[data[i]] = new ArrayList<Integer>();

                List<Integer> list = bucket[data[i]];
                list.add(i + min);
                bucket[data[i]] = list;
            }
        }

        for(int i = bucket.length - 1 ; i >= 0 && res.size() < k; i-- ) {
            if(bucket[i] != null)
                res.addAll(bucket[i]);
        }

        return res;
    }

    //My solution
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> res = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            if(res.containsKey(nums[i])){
                res.put(nums[i],res.get(nums[i])+1);
            }else{
                res.put(nums[i],1);
            }
        }
        List<Map.Entry<Integer,Integer>> temp = new ArrayList<>(res.entrySet());
        temp.sort(Comparator.comparingInt(t->-t.getValue()));
        List<Integer> r = new ArrayList<>();
        for(int i = 0;i< k;i++){
            r.add(temp.get(i).getKey());
        }
        return r;
    }
}

