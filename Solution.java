import java.util.*;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 14:38 2018/1/18
 * @Modified By:
 */
public class Solution {
    //1. Two Sum(两个数之和等于target)(多使用map进行计数)
    public int[] twoSum(int[] nums, int target) {
        int []index = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<=nums.length-1;i++){
            if(map.containsKey(target-nums[i])){
                index[1] = i;
                index[0] = map.get(target-nums[i]);
            }else{
                map.put(nums[i],i);
            }
        }
        return index;
    }

    //2. Add Two Numbers(顺序便利链表)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(-1);
        ListNode start = sum;
        boolean flag = false;
        while(true){
            int num1,num2;
            if(l1 == null && l2 == null && !flag){
                break;
            }
            if(l1 == null){
                num1 = 0;
            }else{
                num1 = l1.val;
                l1 = l1.next;
            }
            if(l2 == null){
                num2 = 0;
            }else{
                num2 = l2.val;
                l2 = l2.next;
            }
            int temp = num1 + num2;
            if(flag){
                temp = temp+1;
                flag = false;
            }
            if(temp >= 10){
                temp = temp % 10;
                flag = true;
            }
            start.next = new ListNode(temp);
            start = start.next;
        }
        return sum.next;
    }

    //3. Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        int begin = 0, max = 0, i = 0;
        boolean[] set = new boolean[1 << 8];
        for (char c: s.toCharArray()) {
            while (set[c]) set[s.charAt(begin++)] = false;
            set[c] = true;
            max = Math.max(max, ++i - begin);
        }
        return max;
    }

    //4. Median of Two Sorted Arrays
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        if(nums1.length == 0 && nums2.length == 0){
            return 0.0;
        } else{
            int []s = new int[(nums1.length+nums2.length)/2+1];
            for(int i = 0,j =0,k=0;k<(nums1.length+nums2.length)/2+1;k++){
                int temp1 = i<nums1.length?nums1[i]:Integer.MAX_VALUE;
                int temp2 = j<nums2.length?nums2[j]:Integer.MAX_VALUE;
                if(temp1 < temp2){
                    s[k] = temp1;
                    i++;
                }else{
                    s[k] = temp2;
                    j++;
                }
            }
            if((nums1.length+nums2.length) % 2 != 0){
                return 1.0*s[s.length-1];
            }else{
                return 1.0*(s[s.length-1]+s[s.length-2])/2;
            }
        }
    }

    //5. Longest Palindromic Substring
    public String longestPalindrome(String str) {
        String s = "$#";//进行串封装，便于统一串长度的奇偶性
        for (int i = 0; i < str.length(); i++)
            s += str.charAt(i) + "#";

        int max = 0;    //记录P数组的最大值。PS：p[i]-1就是原串中    当前位置字母为中心的回文串大小
        int id = 0;     //当前查找位置之前，最大回文串的中心的下标
        int []p = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {//遍历封装串

            int maxLen = p[id] + id;//当前查找位置之前，已知能影响最右边的串

            if (maxLen > i)//当前遍历元素在之前最大回文串的影响范围之内
                p[i] = Math.min(p[2 * id - i], maxLen - i);

            while (i + p[i] < s.length() && i - p[i] >= 0//当前遍历元素在最低长度之上，两边扩张对比
                    && s.charAt(i - p[i]) == s.charAt(i + p[i]))
                ++p[i];

            if (maxLen - id < p[i])//更新已知最大串信息
                id = i;

            if (max < p[i])//保留最大值信息
                max = p[i];
        }
        int length = max - 1;
        int start = (id - max + 1 + 1)/2 -1; //从后来结果中转化到原字符串中
        return str.substring(start,start + length);
    }
    //78. Subsets
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        result.add(tmp); // add empty set
//        Arrays.sort(nums);
        for (int i=0; i<nums.length; i++){
            int n =  result.size();
            for(int j=0; j<n; j++){
                tmp = new ArrayList<Integer>(result.get(j));
                tmp.add(nums[i]);
                result.add(new ArrayList<Integer>(tmp));
            }
        }
        return result;
    }

    //97. Interleaving String
    public boolean isInterleave(String s1, String s2, String s3) {
        if ((s1.length()+s2.length())!=s3.length()) return false;

        boolean[][] matrix = new boolean[s2.length()+1][s1.length()+1];

        matrix[0][0] = true;

        for (int i = 1; i < matrix[0].length; i++){
            matrix[0][i] = matrix[0][i-1]&&(s1.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            matrix[i][0] = matrix[i-1][0]&&(s2.charAt(i-1)==s3.charAt(i-1));
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                matrix[i][j] = (matrix[i-1][j]&&(s2.charAt(i-1)==s3.charAt(i+j-1)))
                        || (matrix[i][j-1]&&(s1.charAt(j-1)==s3.charAt(i+j-1)));
            }
        }

        return matrix[s2.length()][s1.length()];
    }

    //169. Majority Element
    public int majorityElement(int[] nums) {
//        Map<Integer,Integer> res = new HashMap<>();
//        for(int i = 0;i<nums.length;i++){
//            if(res.containsKey(nums[i])){
//                res.put(nums[i],res.get(nums[i])+1);
//            }else{
//                res.put(nums[i],1);
//            }
//            if(res.get(nums[i]) > Math.floor(nums.length/2)){
//                return nums[i];
//            }
//        }
//        return 0;
        int major=nums[0], count = 1;
        for(int i=1; i<nums.length;i++){
            if(count==0){
                count++;
                major=nums[i];
            }else if(major==nums[i]){
                count++;
            }else count--;

        }
        return major;
    }

    //204. Count Primes
    public int countPrimes(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }

    //

    //373. Find K Pairs with Smallest Sums
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> que = new PriorityQueue<>((a, b)->a[0]+a[1]-b[0]-b[1]);
        List<int[]> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) que.offer(new int[]{nums1[i], nums2[0], 0});
        while(k-- > 0 && !que.isEmpty()){
            int[] cur = que.poll();
            res.add(new int[]{cur[0], cur[1]});
            if(cur[2] == nums2.length-1) continue;
            que.offer(new int[]{cur[0],nums2[cur[2]+1], cur[2]+1});
        }
        return res;
    }

    //454. 4Sum II
    public int fourSumCount(int[] A, int[] B,  int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<C.length; i++) {
            for(int j=0; j<D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res=0;
        for(int i=0; i<A.length; i++) {
            for(int j=0; j<B.length; j++) {
                res += map.getOrDefault(-1 * (A[i]+B[j]), 0);
            }
        }

        return res;
    }

    //504. Base 7
    public String convertToBase7(int num) {
        String res = "";
        while(num >= 7 || num <= -7){
            int a = num/7;
            int b = num%7;
            if(b < 0){
                b = -b;
            }
            num = a;
            res = String.valueOf(b)+res;
        }
        return num+res;
    }


    //629. K Inverse Pairs Array
    public int kInversePairs(int n, int k) {
        int mod = 1000000007;
        if (k > n*(n-1)/2 || k < 0) return 0;
        if (k == 0 || k == n*(n-1)/2) return 1;
        long[][] dp = new long[n+1][k+1];
        dp[2][0] = 1;
        dp[2][1] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= Math.min(k, i*(i-1)/2); j++) {
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                if (j >= i) dp[i][j] -= dp[i-1][j-i];
                dp[i][j] = (dp[i][j]+mod) % mod;
            }
        }
        return (int) dp[n][k];
    }

    //653. Two Sum IV - Input is a BST
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        Map<Integer,Integer> key = new HashMap<>();
        Queue<TreeNode> res = new LinkedList<>();
        res.add(root);
        while(!res.isEmpty()) {
            if(res.peek() == null){
                res.poll();
            }else if (key.containsKey(k - res.peek().val)) {
                return true;
            } else {
                key.put(res.peek().val,1);
                res.add(res.peek().left);
                res.add(res.peek().right);
                res.poll();
            }
        }
        return false;
    }

    //658. Find K Closest Elements
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int lo = 0, hi = arr.length - k;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (x - arr[mid] > arr[mid+k] - x)
                lo = mid + 1;
            else
                hi = mid;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = lo;i< lo+k;i++){
            res.add(arr[i]);
        }
        return res;
    }

//    //719. Find K-th Smallest Pair Distance
//    public int smallestDistancePair(int[] nums, int k) {
//
//    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int [][]num1 = new int[][]{{100, 200}, {200, 1300}, {1000, 1250}, {2000, 3200}};
//        System.out.println(s.scheduleCourse(num1));
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
