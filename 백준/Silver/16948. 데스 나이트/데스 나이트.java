import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int r, c, cnt;

    Node(int r, int c, int cnt) {
        this.r = r;
        this.c = c;
        this.cnt = cnt;
    }
}

public class Main {
    static int N;
    static int dr[] = {-2, -2, 0, 0, 2, 2};
    static int dc[] = {-1, 1, -2, 2, -1, 1};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());


        String[] t = br.readLine().split(" ");
        int r1 = Integer.parseInt(t[0]);
        int c1 = Integer.parseInt(t[1]);
        int r2 = Integer.parseInt(t[2]);
        int c2 = Integer.parseInt(t[3]);

        bfs(r1, c1, r2, c2);

    }

    public static void bfs(int r1, int c1, int r2, int c2) {
        visited = new boolean[N + 1][N + 1];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r1, c1, 0));

        while (!que.isEmpty()) {
            Node now = que.poll();
            if (now.r == r2 && now.c == c2) {
                System.out.println(now.cnt);
                return;
            }
            for (int i = 0; i < 6; i++) {
                int nr = now.r + dr[i];
                int nc = now.c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < N && nc < N && !visited[nr][nc]) {
                    que.add(new Node(nr, nc, now.cnt + 1));
                    visited[nr][nc] = true;
                }
            }
        }
        System.out.println(-1);
    }
}
