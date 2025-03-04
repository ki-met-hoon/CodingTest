class Solution {
    public long solution(int price, int money, int count) {
        long ans = 0;
        
        for(int i = 1; i <= count; i++) {
            ans += price * i;
        }
        
        if(ans <= money) {
            return 0;
        }
        
        return ans - money;
    }
}