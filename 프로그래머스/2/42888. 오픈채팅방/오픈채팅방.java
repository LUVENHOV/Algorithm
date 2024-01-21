import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        int count = 0;

        for(int i = 0; i < record.length; i++){
            String[] msg = record[i].split(" ");

            if(msg[0].equals("Leave")){
                continue;
            } else if(msg[0].equals("Enter")){ 
                map.put(msg[1], msg[2]);
            } else {
                map.put(msg[1], msg[2]);
                count++;
            }
        }

        String[] answer = new String[record.length - count];
        int idx = 0;

        for(int i = 0; i < record.length; i++){
            String[] msg = record[i].split(" ");
            String temp = map.get(msg[1]);

            if(msg[0].equals("Enter")){
                answer[idx++] = temp + "님이 들어왔습니다.";
            } else if(msg[0].equals("Leave")){
                answer[idx++] = temp + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}