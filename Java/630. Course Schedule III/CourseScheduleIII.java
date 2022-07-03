class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        
        Arrays.sort(courses, (a, b) -> a[1] - b[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        
        for (int i = 0, total = 0; i < courses.length; i++) {
            pq.add(courses[i][0]);
            if ((total += courses[i][0]) > courses[i][1]) {
                total -= pq.poll();
            }
            
        }
        
        return pq.size();
    }
}