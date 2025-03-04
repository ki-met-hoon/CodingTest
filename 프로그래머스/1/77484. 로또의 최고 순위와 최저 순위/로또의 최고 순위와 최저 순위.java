class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        int[] ans = new int[2];
        
        for(int j = 0; j < lottos.length; j++) {
            if(lottos[j] == 0) {
                    zero++;
                }
            
            for(int i = 0; i < win_nums.length; i++) {
                if(lottos[j] == win_nums[i]) {
                    count++;
                }
            }
        }
        
        if(count == 0) {
            ans[1] = 6;
        } else {
            ans[1] = (6 - count) + 1;
        }
        
        if(ans[1] - zero < 1) {
            ans[0] = 1;
        } else {
            ans[0] = ans[1] - zero;
        }
        
        return ans;
    }
}