import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] rr = {-1, 0, 1, 0};
    static int[] rc = {0, 1, 0, -1};
    static int[][] board;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        while (true) {
            if (CntBfs(board) == 0) {
                answer = 0;
                break;
            }
            if (CntBfs(board) >= 2) {
                break;
            }
            bfs();
            answer++;
        }
        System.out.println(answer);

    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] != 0) {
                    q.add(new int[]{i, j});
                    visit[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int x = temp[0];
            int y = temp[1];

            for (int dir = 0; dir < 4; dir++) {
                int nx = x + rr[dir];
                int ny = y + rc[dir];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if (visit[nx][ny]) continue;
                if (board[nx][ny] == 0) {
                    if (board[x][y] > 0)
                        board[x][y]--;
                }

            }
        }
    }

    static int CntBfs(int[][] boards) {
        int ans = 0;
        boolean[][] chk = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (boards[i][j] != 0 && !chk[i][j]) {
                    queue.add(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int nr = now[0];
                        int nc = now[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = nr + rr[d];
                            int ny = nc + rc[d];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && boards[nx][ny] != 0 && !chk[nx][ny])
                                {
                                    queue.add(new int[]{nx, ny});
                                    chk[nx][ny] = true;
                                }
                        }
                    }
                    ans++;
                }
            }
        }


        return ans;
    }
}