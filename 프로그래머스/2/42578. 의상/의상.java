import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String[] row : clothes) {
            String name = row[0];
            String kind = row[1];
            
            if (map.containsKey(kind)) {
                map.get(kind).add(name);
                continue;
            }

            map.put(kind, new ArrayList<>());
            map.get(kind).add(name);
        }
        
        for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            answer *= entry.getValue().size() + 1;
        }
        
        return answer - 1;
    }
}