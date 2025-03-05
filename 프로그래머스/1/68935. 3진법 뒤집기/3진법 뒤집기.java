import java.util.*;

class Solution {
    public int solution(int n) {
        ArrayList<String> list = new ArrayList<>();
        
        while(n / 3 != 0) {
            list.add(String.valueOf(n % 3));
            n = n / 3;
        }
        
        list.add(String.valueOf(n % 3));
        String ans = String.join("", list);
        return Integer.parseInt(ans, 3);
    }
}