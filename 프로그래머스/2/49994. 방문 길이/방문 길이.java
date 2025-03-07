import java.util.*;

class Solution {
    private static int[] mx = {0, -1, 0, 1};
    private static int[] my = {1, 0, -1, 0};
    
    public int solution(String dirs) {
        HashSet<String> visited = new HashSet<>();
        
        String move = "ULDR";
        Node cur = new Node(0, 0);
        
        for(char dir : dirs.toCharArray()){
            int i = move.indexOf(dir);
            String str = "";
            
            int nx = cur.x + mx[i];
            int ny = cur.y + my[i];
            
            if(!(-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5)) {
                continue;
            }
            
            if(dir == 'D' || dir == 'R') {
                str += nx + "" + ny + "" + cur.x + "" + cur.y;
                visited.add(str);
                
                cur.move(nx, ny);
                continue;
            }
            
            str += cur.x + "" + cur.y + "" + nx + "" + ny;
            visited.add(str);
            cur.move(nx, ny);
        }
        
        return visited.size();
    }
    
    private class Node {
        int x;
        int y;
        
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public void move(int dx, int dy) {
            this.x = dx;
            this.y = dy;
        }
    }
}