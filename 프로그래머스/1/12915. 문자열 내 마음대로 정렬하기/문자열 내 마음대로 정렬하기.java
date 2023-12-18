import java.util.*;

class Solution {
  public String[] solution(String[] strings, int n) {
      String[] answer = {};
        answer = new String[strings.length];
        int cnt = 0;
        
        Arrays.sort(strings);
        
        for(int i = 97; i < 123; i++) {
            for(int j = 0; j < strings.length; j++) {
                if(strings[j].charAt(n) == (char)i) {
                    answer[cnt++] = strings[j];
                }
            }
        }
        return answer;
  }
}