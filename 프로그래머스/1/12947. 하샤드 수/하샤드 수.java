class Solution {
    public boolean solution(int x) {
        int checkNum = 0;
        
        char[] num = String.valueOf(x).toCharArray();
        
        for(int i = 0; i < num.length; i++) {
            checkNum += Character.getNumericValue(num[i]);
        }
        
        System.out.println(checkNum);
        
        if(x % checkNum == 0) {
            return true;
        }
        
        return false;
    }
}