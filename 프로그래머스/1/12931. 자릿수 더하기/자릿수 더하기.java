import java.util.*;

public class Solution {
    public int solution(int n) {
        String[] nums = String.valueOf(n).split("");
        int ans = 0;
        
        for(String number : nums) {
            ans += Integer.parseInt(number);
        }
        
        return ans;
    }
}