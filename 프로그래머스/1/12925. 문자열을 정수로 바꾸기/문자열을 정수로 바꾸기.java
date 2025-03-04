class Solution {
    public int solution(String s) {
        int ans = 0;
        
        if(Character.isDigit(s.charAt(0))) {
            ans = Integer.parseInt(s.substring(0, s.length()));
        } else {
            ans = Integer.parseInt(s.substring(1, s.length()));
        } 
        
        if(s.charAt(0) == '-') {
            return ans * -1;
        }
        
        return ans;
    }
}