import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int count = 0;
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++){
            count += d[i];
            if(count > budget){
                answer = i;
                break;
            }
        }
        
        if(count <= budget) answer = d.length;
        
        return answer;
    }
}