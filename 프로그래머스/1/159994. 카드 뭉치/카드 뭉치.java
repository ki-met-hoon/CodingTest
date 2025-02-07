class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int pointer1 = 0;
        int pointer2 = 0;
        
        for(int i = 0; i < goal.length; i++) {
            if (pointer1 < cards1.length && cards1[pointer1].equals(goal[i])) {
                pointer1++;
                continue;
            }
            
            if (pointer2 < cards2.length && cards2[pointer2].equals(goal[i])) {
                pointer2++;
                continue;
            }
            
            return "No";
        }
        
        return "Yes";
    }
}