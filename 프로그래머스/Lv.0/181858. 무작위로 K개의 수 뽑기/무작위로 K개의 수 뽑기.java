import java.util.ArrayList;

class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for( int num : arr) {
            list.add(num);
        }
        
        int length = 1;
        
        while(length < list.size()){
            length += 2;
        }
        
       while(list.size() < length) list.add(0);
            
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}