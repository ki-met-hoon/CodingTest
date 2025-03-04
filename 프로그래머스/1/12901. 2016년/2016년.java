class Solution {
    public String solution(int a, int b) {
        int ans = b - 1;
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        for(int i = 1; i < a; i++) {
            if(i % 2 == 1) {
                if(i == 9) {
                    ans += 30;
                    continue;
                }
                
                if(i == 11) {
                    ans += 30;
                    continue;
                }
                
                ans += 31;
            }
            
            if(i % 2 == 0) {
                if (i == 2) {
                    ans += 29;
                    continue;
                }
                
                if (i == 8) {
                    ans += 31;
                    continue;
                }
                
                if(i == 10) {
                    ans += 31;
                    continue;
                }
                
                ans += 30;
            }    
        }
        
        return day[ans % 7];
    }
}