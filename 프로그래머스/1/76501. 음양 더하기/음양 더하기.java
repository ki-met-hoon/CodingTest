class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int ans = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
            if (signs[i]) {
                ans += absolutes[i];
                continue;
            }
            
            ans += absolutes[i] * -1;
        }
        
        return ans;
    }
}