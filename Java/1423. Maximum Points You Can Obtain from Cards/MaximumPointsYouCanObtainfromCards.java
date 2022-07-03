class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int totalPoints = Arrays.stream(cardPoints).sum();
        int n = cardPoints.length - k; // keep n elements
        
        int sumOfCurrentWindow = 0;
        
        for (int i = 0; i < n; i++) {
            sumOfCurrentWindow += cardPoints[i];
        }
        
        int answer = totalPoints - sumOfCurrentWindow;
        
        for (int i = n; i < cardPoints.length; i++) {
            sumOfCurrentWindow = sumOfCurrentWindow - cardPoints[i-n]
                 + cardPoints[i];
            answer = Math.max(answer, totalPoints - sumOfCurrentWindow);
        }
        
        return answer;
        
    }
}