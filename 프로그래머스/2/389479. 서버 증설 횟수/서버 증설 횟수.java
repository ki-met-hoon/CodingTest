import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int ans = 0;
        int serverCnt = 1;
        ArrayList<Server> server = new ArrayList<>();
        
        for (int i = 0; i < players.length; i++) {
            if (!server.isEmpty() && server.get(0).time == i) {
                serverCnt -= server.get(0).cnt;
                server.remove(0);
            }
            
            if (players[i] >= (m * serverCnt)) {
                ans += (players[i] / m - serverCnt + 1);
                server.add(new Server(i + k, (players[i] / m - serverCnt + 1)));
                serverCnt = players[i] / m + 1;
            }
        }
        
        return ans;
    }
    
    private class Server {
        int time;
        int cnt;
        
        public Server(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
    }
}
