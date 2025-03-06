import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Node> list = new ArrayList<>();
        
        for(int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int weight : map.keySet()) {
            Node node = new Node(weight, map.get(weight));
            list.add(node);
        }
        
        list.sort((o1, o2) -> o1.count - o2.count);
            
        int ans = 0;
        
        for(int i = list.size() - 1; i >= 0; i--) {
            if(k <= 0) {
                break;
            }
            
            int nodeCount = list.get(i).count;
            k -= nodeCount;
            ans ++;
        }
        
        return ans;
    }
    
    private class Node {
        int weight;
        int count;
        
        public Node(int weight, int count) {
            this.weight = weight;
            this.count = count;
        }
    }
}