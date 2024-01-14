import java.util.*;

class Pair {
    int progress;
    int speed;

    public Pair(int progress, int speed){
        this.progress = progress;
        this.speed = speed;
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list =  new ArrayList<>();

        Queue<Pair> que = new LinkedList<>();

        for(int i = 0; i < progresses.length ; i++){
            que.add(new Pair(progresses[i], speeds[i]));
        }

        while(!que.isEmpty()){
            //1일치 작업
            for(int i = 0; i < que.size(); i++){
                Pair now = que.poll();
                now.progress += now.speed;
                que.add(now);
            }

            int finished = 0;
            int size = que.size();
            //완료된 작업
            for(int i = 0; i < size; i++){
                if (que.peek().progress >= 100){
                    que.poll();
                    finished++;
                } else break;
            }

            if(finished != 0){
                list.add(finished);
            }
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}