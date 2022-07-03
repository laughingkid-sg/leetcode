class MaximumUnitsOnATruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // Sort DESC Order
        Arrays.sort(boxTypes, (a,b) -> b[1] - a[1] );
        int result = 0;
        for (int i = 0; i < boxTypes.length && truckSize > 0; i++) {
            int maxi = Math.min(boxTypes[i][0], truckSize);
			result += maxi * boxTypes[i][1];
            truckSize -= maxi;
        }
        return result;
    }
}