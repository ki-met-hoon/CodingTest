class Solution {
    public String solution(int n) {
        StringBuffer sb = new StringBuffer();
        
        for(int i = 1; i <= n; i++) {
            if(i % 2 != 0) {
                sb.append("수");
                continue;
            }
            
            sb.append("박");
        }
        
        return sb.toString();
    }
}