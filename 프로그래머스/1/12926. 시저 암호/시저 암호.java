class Solution {
    public String solution(String s, int n) {
        int[] ASCII = s.chars().toArray();
        StringBuffer sb = new StringBuffer();
        
        for(int index = 0; index < ASCII.length; index++) {
            if (Character.isUpperCase(ASCII[index])) {  // 대문자
                sb.append((char) ((ASCII[index] - 65 + n) % 26 + 65));
            } else if (Character.isLowerCase(ASCII[index])) {  // 소문자
                sb.append((char) ((ASCII[index] - 97 + n) % 26 + 97));
            } else {
                sb.append((char) ASCII[index]);
            }
        }
        
        return String.valueOf(sb);
    }
}