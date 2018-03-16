import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: LiJian
 * @Description:
 * @Date: Created in 9:58 2018/3/16
 * @Modified By:
 */
public class question632 {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] result = new int[2];
        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new Comparator<Pair>(){
            @Override
            public int compare(Pair p1, Pair p2) {
                return p1.val - p2.val;
            }

        });
        int endVal = Integer.MIN_VALUE;
        int k = nums.size();
        for (int i = 0; i < k; i++) {
            endVal = Math.max(endVal, nums.get(i).get(0));
            minHeap.offer(new Pair(i, 0, nums.get(i).get(0)));
        }
        int startVal = minHeap.peek().val;
        result[0] = startVal;
        result[1] = endVal;
        while (!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            int row = curr.row;
            int col = curr.col + 1;
            if (col < nums.get(row).size()) {
                minHeap.offer(new Pair(row, col, nums.get(row).get(col)));
                endVal = Math.max(endVal, nums.get(row).get(col));
            }
            else {
                break;
            }
            startVal = minHeap.peek().val;
            if (smallerRange(startVal, endVal, result)) {
                result[0] = startVal;
                result[1] = endVal;
            }
        }
        return result;

    }
    private boolean smallerRange(int startVal, int endVal, int[] result) {
        if (endVal - startVal < result[1] - result[0]) {
            return true;
        }
        else if (endVal - startVal == result[1] - result[0]) {
            return startVal < result[0];
        }
        else {
            return false;
        }
    }
}

class Pair {
    int row, col, val;
    public Pair(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

