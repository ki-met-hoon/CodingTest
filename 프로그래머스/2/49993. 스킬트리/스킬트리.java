import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int count = 0;
        
        for (int i = 0; i < skill_trees.length; i++) {
            String reqStr = skill_trees[i].replaceAll("[^" + skill + "]", "");
            
            for (int j = 0; j < reqStr.length(); j++) {
                if (skill.charAt(j) != reqStr.charAt(j)) {
                    count++;
                    break;
                }
            }
        }
        
        return skill_trees.length - count;
    }
}