class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        
        if((int) num == num) {
            return (long) Math.pow(num + 1, 2);
        }
        
        return -1;
    }
}