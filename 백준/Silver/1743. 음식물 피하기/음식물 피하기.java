import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class pair {
    int x;
    int y;

    public pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M, K, ans, cnt;
    static int rr[] = {0, 0, -1, 1};
    static int rc[] = {-1, 1, 0, 0};
    static boolean[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new boolean[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            board[r - 1][c - 1] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && board[i][j]) {
                    cnt = 0;
                    bfs(i, j);
                    ans = Math.max(ans, cnt);
                }
            }
        }
        System.out.println(ans);

    }

    private static void bfs(int x, int y) {
        ArrayDeque<pair> q = new ArrayDeque<>();
        q.add(new pair(x, y));
        visited[x][y] = true;
        cnt++;
        while (!q.isEmpty()) {
            pair temp = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = temp.x + rr[d];
                int nc = temp.y + rc[d];

                if (nr >= 0 && nc >= 0 && nr < N & nc < M && !visited[nr][nc] && board[nr][nc]) {
                    q.add(new pair(nr, nc));
                    visited[nr][nc] = true;
                    cnt++;
                }
            }
        }
    }
}
