class Solution {
    public String solution(String phone_number) {
        int count = 0;
        char[] num = phone_number.toCharArray();
        
        for(int i = phone_number.length() - 1; i >= 0; i--) {
            if(count < 4) {
                count++;
                continue;
            }
            
            num[i] = '*';
        }
        
        return String.valueOf(num);
    }
}