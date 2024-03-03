import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    public int[] solution(String[] gems) {

        int type = new HashSet<>(Arrays.asList(gems)).size();

        int[] answer = new int[2];

        int length = Integer.MAX_VALUE;
        int index = 0;

        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < gems.length; i++){
            map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
            
            while(map.get(gems[index]) > 1) {
                map.put(gems[index], map.get(gems[index]) - 1);
                index++;
            }
            
            if(map.size() == type && length > (i - index)) {
                length = i - index;
                answer[0] = index + 1;
                answer[1] = i + 1;
            }
            
        }

        return answer;
    }
}
