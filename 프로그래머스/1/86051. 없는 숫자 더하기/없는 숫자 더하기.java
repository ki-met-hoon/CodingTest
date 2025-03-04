class Solution {
    public int solution(int[] numbers) {
        int ans = 0;
        
        for(int i = 0; i < numbers.length; i++) {
            ans += numbers[i];
        }
        
        return 45 - ans;
    }
}