import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> ans = new ArrayList<>();
        
        HashMap<String, Integer> genreMap = new HashMap<>();
        HashMap<String, List<numPlays>> numPlayMap = new HashMap<>();
        
        for(int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            numPlayMap.putIfAbsent(genres[i], new ArrayList<>());
            numPlayMap.get(genres[i]).add(new numPlays(i, plays[i]));
        }
        
        List<String> keySet = new ArrayList<>(genreMap.keySet());
        
        keySet.sort((o1, o2) -> genreMap.get(o2) - genreMap.get(o1));
        
        for(String key : keySet) {
            List<numPlays> numPlayList = numPlayMap.get(key);
            numPlayList.sort((o1, o2) -> o2.plays - o1.plays);
            
            ans.add(numPlayList.get(0).num);
            
            if(numPlayList.size() != 1) {
                ans.add(numPlayList.get(1).num);
            }
        }
        
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private class numPlays {
        int num;
        int plays;
        
        public numPlays(int num, int plays) {
            this.num = num;
            this.plays = plays;
        }
    }
}