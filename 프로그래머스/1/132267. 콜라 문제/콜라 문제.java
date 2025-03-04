class Solution {
    public int solution(int a, int b, int n) {
        int ans = 0;
        
        while(true) {
            if(a > n) {
                return ans;
            }
            
            ans += (n / a * b);
            n = n - (n / a * a) + (n / a * b);
        }
    }
}