class Solution {
    public String solution(String s) {
        if(s.length() % 2 == 1) {
            return s.split("")[s.length() / 2];
        } else {
            return s.split("")[s.length() / 2 - 1] + s.split("")[s.length() / 2];
        }
    }
}