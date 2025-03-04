class Solution {
    public long solution(int a, int b) {
        long max = Math.max(a, b);
        long min = Math.min(a, b);
        long ans = 0;
        
        for(long i = min; i <= max; i++) {
            ans += i;
        }
        
        return ans;
    }
}