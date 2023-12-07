import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Move{
    int num, move;
    public Move(int num, int move) {
        this.num = num;
        this.move = move;
    }
}
public class Main {
    static boolean[] NotPrime = new boolean[100001];

    //소수 판별 메서드
    static void PrimeCheck() {
        for(int i = 2; i < 10000; i++){
            if(!NotPrime[i]) {
                for(int j = i*i; j < 10000; j += i){
                    NotPrime[j] = true;
                }
            }
        }
    }

    //비밀번호 변경 메서드
    static int changePW(int[] password){
        int num = 0;
        for(int i = 0; i < 4; i++){
            num += password[i] * (Math.pow(10,3-i));
        }
        return num;
    }

    //bfs
    static String bfs(int src, int answer) {
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        map.put(src,0);
        q.add(src);

        while(!q.isEmpty()) {
            int pos = q.poll();
            int move = map.get(pos);

            if(pos == answer) {
                return move+"";
            }

            int[] curPW = {pos/1000, (pos/100)%10, (pos/10)%10, pos%10};
            for(int i=0; i<4; i++) {
                for(int j=0; j<10; j++) {
                    if(i==0 && j==0) continue; // 1000이상

                    int tmp = curPW[i];
                    curPW[i] = j;
                    int next = changePW(curPW);
                    curPW[i] = tmp;

                    if(NotPrime[next]) continue;

                    if(!map.containsKey(next)) {
                        q.add(next);
                        map.put(next, move+1);
                    }
                }
            }
        }

        return "Impossible";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        //소수
        PrimeCheck();

        for(int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cur = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(cur==end){
                System.out.println(0);
                continue;
            }

            String answer = bfs(cur, end);

            System.out.println(answer);

        }
    }

}
