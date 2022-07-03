import java.util.Collections;
import java.util.PriorityQueue;

class ConstructTargetArrayWithMultipleSums {
    public boolean isPossible(int[] target) {
        if (target.length == 1) {
            return target[0] == 1;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        
        for (int i : target) {
            pq.add(i);
            sum += i;
        }
        
        while (pq.peek() != 1) {
            int currLargest = pq.poll();
            if (sum - currLargest == 1) {
                return true;
            }
            
            int i = currLargest % (sum - currLargest);
            sum = sum - currLargest + i;
            
            if (i == 0 || i == currLargest) {
                return false;
            } else {
                pq.add(i);
            }
        }
        
        return true;
     
    }
}