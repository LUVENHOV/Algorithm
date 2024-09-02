import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int visited[];
    static int bridge[];
    static int dir[] = {1, -1};
    static int cnt = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        bridge = new int[N];
        visited = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            bridge[i] = Integer.parseInt(st.nextToken());
        }

        int s = Integer.parseInt(br.readLine());
        System.out.println(bfs(s-1));

    }

    public static int bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = 1; // 방문한 곳 체크
        while (!queue.isEmpty()) {
            node = queue.poll();
            int jump = bridge[node];
            for (int d : dir) {
                int temp = (d * jump) + node;
                if (temp >= 0 && temp < N && visited[temp] == 0) {
                    visited[temp] = 1;
                    queue.add(temp);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}