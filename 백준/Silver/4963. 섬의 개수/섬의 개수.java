import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int W, H;
    static int[][] board;
    static boolean[][] visited;
    static int[] rr = {0, 0, 1, -1, -1, 1, -1, 1};
    static int[] rc = {1, -1, 0, 0, -1, 1, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            if (W == 0 && H == 0) {
                break;
            }

            board = new int[H][W];
            visited = new boolean[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < W; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;

            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (board[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
    }

    public static void dfs(int r, int c) {
        visited[r][c] = true;

        for (int i = 0; i < 8; i++) {
            int nr = r + rr[i];
            int nc = c + rc[i];

            if (nr >= 0 && nc >= 0 && nr < H && nc < W) {
                if (board[nr][nc] == 1 && !visited[nr][nc]) {
                    dfs(nr, nc);
                }
            }
        }
    }
}
