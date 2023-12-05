import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int cur = -1;
        for(int i = 0; i < arr.length; i++){
            if (arr[i] != cur){
                list.add(arr[i]);
                cur = arr[i];
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 0; i< list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}