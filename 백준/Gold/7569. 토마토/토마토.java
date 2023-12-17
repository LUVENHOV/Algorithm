import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class tomato {
    int h, r ,c;
    public tomato(int h, int r, int c) {
        this.h = h;
        this.r = r;
        this.c = c;
    }
}

public class Main {
    static int M, N, H;
    static int[][][] arr;

    static int[] dh = {-1, 1, 0, 0, 0, 0};
    static int[] dr = {0, 0, 0, 0, -1, 1};
    static int[] dc = {0, 0, -1, 1, 0, 0};
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    arr[h][n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }
        int[][][] time = new int[H][N][M];

        Queue<tomato> queue = new LinkedList<>();
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 1) {
                        queue.add(new tomato(h, n, m));
                    }
                }
            }
        }

        while (!queue.isEmpty()) {
            tomato now = queue.poll();

            for (int d = 0; d < 6; d++) {
                int nh = now.h + dh[d];
                int nr = now.r + dr[d];
                int nc = now.c + dc[d];

                if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M
                        && arr[nh][nr][nc] == 0) {
                    arr[nh][nr][nc] = 1;
                    queue.add(new tomato(nh, nr, nc));
                    time[nh][nr][nc] = time[now.h][now.r][now.c] + 1;
                }
            }
        }

        int max = 0;
        
        loop: for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (arr[h][n][m] == 0) {
                        max = -1;
                        break loop;
                    }
                    max = Math.max(max, time[h][n][m]);
                }
            }
        }

        System.out.println(max);
    }
}

