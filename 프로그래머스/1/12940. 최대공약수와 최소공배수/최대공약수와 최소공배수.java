class Solution {
    public int[] solution(int n, int m) {
        int[] ans = new int[2];
        
        int max = Math.max(n, m);
        int min = Math.min(n, m);
        
        ans[0] = GCD(max, min);
        ans[1] = n * m / ans[0];
        
        return ans;
    }
    
    private int GCD(int i, int j) {
        int k = i % j;
        
        if (k == 0) {
            return j;
        }
        
        return GCD(j, k);
    }
}