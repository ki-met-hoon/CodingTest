class Solution {
    public String solution(int[] food) {
        String left = "";
        
        for(int i = 1; i < food.length; i++) {
            if(food[i] % 2 == 0) {
                food[i] /= 2;
                continue;
            }
            
            food[i] -= 1;
            food[i] /= 2;
        }
        
        for(int i = 1; i < food.length; i++) {
            for(int j = 0; j < food[i]; j++) {
                left += String.valueOf(i);
            }
        }
        
        StringBuffer sb = new StringBuffer(left);
        String right = sb.reverse().toString();
        System.out.println(right);
        
        return left + "0" + right;
    }
}