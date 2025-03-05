import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        
        // X의 각 자리 숫자 개수 세기
        for(int i = 0; i < X.length(); i++) {
            countX[X.charAt(i) - '0']++;
        }
        
        // Y의 각 자리 숫자 개수 세기
        for(int i = 0; i < Y.length(); i++) {
            countY[Y.charAt(i) - '0']++;
        }
        
        StringBuilder sb = new StringBuilder();
        
        // 공통 숫자 찾기 (9부터 0까지 역순으로)
        for(int i = 9; i >= 0; i--) {
            int common = Math.min(countX[i], countY[i]);
            for(int j = 0; j < common; j++) {
                sb.append(i);
            }
        }
        
        if(sb.length() == 0) {
            return "-1";
        }
        
        // 결과가 0으로만 이루어진 경우
        if(sb.charAt(0) == '0') {
            return "0";
        }
        
        return sb.toString();
    }
}