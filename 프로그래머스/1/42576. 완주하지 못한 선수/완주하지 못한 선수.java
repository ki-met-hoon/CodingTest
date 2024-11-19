import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        String answer = "";

        for (String name : participant) {
            hashMap.putIfAbsent(name, 0);
            hashMap.replace(name, hashMap.get(name) + 1);
        }

        for (String name : completion) {
            if (hashMap.containsKey(name)) {
                if (hashMap.get(name) == 1) {
                    hashMap.remove(name);
                    continue;
                }

                hashMap.replace(name, hashMap.get(name) - 1);
            }
        }

        for (String key : hashMap.keySet()) {
            answer = key;
        }

        return answer;
    }
}