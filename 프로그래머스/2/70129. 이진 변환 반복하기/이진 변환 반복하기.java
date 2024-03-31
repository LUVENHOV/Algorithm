import java.util.*;

class Solution {
  public int[] solution(String s) {
    int[] answer = new int[2];
      
    while(!s.equals("1")) {
        answer[0]++;
        String str = s.replaceAll("0", "");
        answer[1] += s.length() - str.length();
        s = Integer.toBinaryString(str.length()).toString();
    }
 
    return answer;
  }
}
  