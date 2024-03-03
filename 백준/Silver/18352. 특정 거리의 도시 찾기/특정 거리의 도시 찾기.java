import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<Integer>[] cities = new List[N+1];

        for(int i = 1; i <= N; i++) cities[i] = new ArrayList<>();
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());
            cities[num1].add(num2);
        }

        int[] dist = new int[N+1];
        Arrays.fill(dist, -1);
        Queue<Integer> que = new LinkedList<>();
        que.add(X);
        dist[X] = 0;

        List<Integer> answer = new ArrayList<>();

        while(!que.isEmpty()){
            int now = que.poll();
            if (dist[now] > K) break;
            if (dist[now] == K) answer.add(now);

            for(int next: cities[now]){
                if(dist[next] != -1) continue;
                dist[next] = dist[now] + 1;
                que.add(next);
            }
        }

        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for (int now : answer) {
            sb.append(now).append('\n');
        }

        System.out.println(answer.isEmpty() ? -1 : sb);

    }

}
