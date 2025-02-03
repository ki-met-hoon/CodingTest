import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Truck_location> q = new ArrayDeque<>();
        int count = 0;
        int curWeight = 0;
        int idx = 0;
        
        while(idx < truck_weights.length || !q.isEmpty()) {
            count++;
            
            if(!q.isEmpty()) {
                if(count - q.peekLast().location >= bridge_length) {
                    Truck_location t = q.removeLast();
                    curWeight -= t.weight;
                }
            }
            
            if(idx < truck_weights.length) {
                if(curWeight + truck_weights[idx] <= weight && q.size() < bridge_length) {
                    q.addFirst(new Truck_location(truck_weights[idx], count));
                    curWeight += truck_weights[idx];
                    idx++;
                }
            }
        }
        
        return count;
    }
    
    private class Truck_location {
        int weight;
        int location;
        
        public Truck_location(int weight, int location) {
            this.weight = weight;
            this.location = location;
        }
    }
}