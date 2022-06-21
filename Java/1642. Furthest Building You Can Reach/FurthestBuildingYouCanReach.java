import java.util.PriorityQueue;

class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int diff;
        for (int i = 0; i < heights.length - 1; i++) {

            // find difference next and current
            diff = heights[i + 1] - heights[i];

            // if next building is taller, add to pq
            if (diff > 0) {
                pq.add(diff);
            }

            // if all ladders use up, use bricks
            if (pq.size() > ladders) {
                bricks -= pq.poll();
            }

            // if all bricks used 
            if (bricks < 0) {
                return i;
            }
        }
        
        return heights.length - 1;
    }
}