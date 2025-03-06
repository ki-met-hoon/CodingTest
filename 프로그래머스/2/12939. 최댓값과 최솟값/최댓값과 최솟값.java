import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuffer sb = new StringBuffer();
        
        int[] num = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(num);
        
        sb.append(String.valueOf(num[0]));
        sb.append(" ");
        sb.append(String.valueOf(num[num.length - 1]));
        
        return sb.toString();
    }
}