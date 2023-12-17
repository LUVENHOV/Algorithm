import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair {
    int r, c;

    Pair(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        ArrayList<Pair> a;
        ArrayList<ArrayList<Integer>> graph;

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());

            a = new ArrayList<>();

            // 집, 편의점, 페스티벌에 위치를 저장함.
            for (int i = 0; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                a.add(new Pair(x, y));
            }

            graph = new ArrayList<>();
            for (int i = 0; i < N + 2; i++) {
                graph.add(new ArrayList<>());
            }

            // 거리 1000m 이하를 만족하는 두 정점 탐색
            for (int i = 0; i < N + 2; i++) {
                for (int j = i + 1; j < N + 2; j++) {
                    if (Length(a.get(i), a.get(j)) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            sb.append((BFS(graph, N) ? "happy" : "sad") + '\n');
        }

        System.out.println(sb.toString());

    }
    
    public static int Length(Pair a, Pair b) {
        return Math.abs(a.r- b.r) + Math.abs(a.c - b.c);
    }

    public static boolean BFS(ArrayList<ArrayList<Integer>> graph, int N) {
        Queue<Integer> q = new LinkedList<>();
        q.add(0);

        boolean[] visited = new boolean[N + 2];
        visited[0] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            if (now == N + 1) {
                return true;
            }

            for (int next : graph.get(now)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.add(next);
                }
            }
        }

        return false;
    }

}