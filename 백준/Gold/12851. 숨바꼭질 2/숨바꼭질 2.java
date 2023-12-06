import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, count;
    static int[] time = new int[100001];
    static int minTime = Integer.MAX_VALUE;

    static void bfs() {

        Queue<Integer> que = new LinkedList<>();
        que.add(N);
        time[N] = 1;

        while(!que.isEmpty()){
            int now = que.poll();

            //min 시간이 현재 시간보다 작으면 탐색 필요 X
            if(minTime < time[now]) return;

            // * 2 , + 1, - 1
            for(int i = 0; i < 3; i++){
                int next;

                if(i == 0) next = now * 2;
                else if(i == 1) next = now + 1;
                else next = now - 1;

                //범위 벗어나면 continue;
                if (next < 0 || next > 100000) continue;

                // 다음 값이 K면 minTime 갱신하고 count++
                if (next == K) {
                    minTime = time[now];
                    count++;
                }

                //첫 방문이거나 이미 방문했어도 같은 시간이라면 중복될 수 있음
                if (time[next] == 0 || time[next] == time[now] + 1) {
                    que.add(next);
                    time[next] = time[now] + 1;
                }

            }
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        //N이 K보다 크거나 같으면 한 칸씩 이동해서만 찾기 가능
        if(N >= K){
            System.out.println((N-K) + "\n1");
            return;
        }

        bfs();

        System.out.println(minTime + "\n" + count);

    }

}
