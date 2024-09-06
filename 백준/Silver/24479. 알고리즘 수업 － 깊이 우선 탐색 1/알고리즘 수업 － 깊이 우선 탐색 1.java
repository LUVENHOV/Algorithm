import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int cnt;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int tmp1 = Integer.parseInt(st.nextToken());
            int tmp2 = Integer.parseInt(st.nextToken());

            list.get(tmp1).add(tmp2);
            list.get(tmp2).add(tmp1);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(list.get(i));
        }

        cnt = 1;
        dfs(R);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);

    }

    private static void dfs(int now) {

        visited[now] = cnt;

        for (int i = 0; i < list.get(now).size(); i++) {
            int next = list.get(now).get(i);
            if (visited[next] == 0) {
                cnt++;
                dfs(next);
            }
        }

    }
}
