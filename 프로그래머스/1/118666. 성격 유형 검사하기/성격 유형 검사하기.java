import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : types){
            map.put(c, 0);
        }
        
        for(int i = 0; i < survey.length; i++){
            char[] c = survey[i].toCharArray();
            if(choices[i] > 4){
                int currentValue = map.get(c[1]);
                map.put(c[1], currentValue + choices[i]-4);
            } else if(choices[i] < 4){
                int[] value = {0,3,2,1};
                int currentValue = map.get(c[0]);
                map.put(c[0], currentValue + value[choices[i]]);
            }
        }
        
        for(int i = 0; i < types.length; i+=2){
            if(map.get(types[i]) > map.get(types[i+1])) {
                answer += types[i];
            } else if (map.get(types[i]) < map.get(types[i+1])){
                answer += types[i+1];
            } else answer += types[i];
        }
        
        
        return answer;
    }
}