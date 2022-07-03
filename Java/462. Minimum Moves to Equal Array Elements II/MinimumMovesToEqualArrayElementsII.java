class MinimumMovesToEqualArrayElementsII {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        
        int mid = nums[nums.length/2];
        
        int result = 0;
        
        for (int i = 0; i < nums.length ; i++) {
            result += Math.abs(mid-nums[i]);
        }
        
        return result;
    }
}