class MaximumAreaOfAPieceOfCakeAfterHorizontalAndVerticalCuts {
    
    private static final int MOD = (int) 1e9 + 7;
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long max_h = horizontalCuts[0];
        long max_w = verticalCuts[0];
        
        for (int i = 1; i < horizontalCuts.length; i++) {
            max_h = Math.max(horizontalCuts[i] - horizontalCuts[i-1], max_h);
        }
        
        for (int i = 1; i < verticalCuts.length; i++) {
            max_w = Math.max(verticalCuts[i] - verticalCuts[i-1], max_w);
        }
        
        max_h = Math.max(h - horizontalCuts[horizontalCuts.length - 1], max_h);
        max_w = Math.max(w - verticalCuts[verticalCuts.length - 1], max_w);
        
        
        return (int) ((max_h * max_w) % MOD);
    }
}

// https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/discuss/2231989/Java-Solution-Using-Sorting