class Solution {
    public long[] solution(int x, int n) {
        long[] ans = new long[n];
        
        for(int i = 0; i < n; i++) {
            ans[i] = x * (long) (i + 1);
        }
        
        return ans;
    }
}