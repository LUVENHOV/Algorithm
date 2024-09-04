import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int I;
    static int r1, r2, c1, c2;
    static int[][] board;
    static boolean[][] visited;
    static int[] rr = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] rc = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            I = Integer.parseInt(br.readLine());

            board = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            r1 = Integer.parseInt(st.nextToken());
            c1 = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            r2 = Integer.parseInt(st.nextToken());
            c2 = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(board[r2][c2]).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{r1, c1});
        visited[r1][c1] = true;

        while (!que.isEmpty()) {
            int[] now = que.poll();
            int r = now[0];
            int c = now[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + rr[i];
                int nc = c + rc[i];

                if (nr >= 0 && nc >= 0 && nr < I && nc < I) {
                    if (!visited[nr][nc]) {
                        que.add(new int[]{nr, nc});
                        board[nr][nc] = board[r][c] + 1;
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}