import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, T, min;
    static int[][] board;
    static boolean[][][] visited;
    static int[] rr = {-1, 0, 1, 0};
    static int[] rc = {0, -1, 0, 1};

    static class Warrior {
        int r, c, t, sword;

        public Warrior(int r, int c, int t, int sword) {
            this.r = r;
            this.c = c;
            this.t = t;
            this.sword = sword;
        }
    }

    static void bfs() {
        Queue<Warrior> que = new LinkedList<>();
        que.add(new Warrior(0, 0, 0, 0));
        visited[0][0][0] = true;

        while (!que.isEmpty()) {
            Warrior now = que.poll();
            //시간 초과 시 continue
            if (now.t > T) continue;
            //공주한테 도착 시 min time 갱신
            if ((now.r == N - 1) && (now.c == M - 1)) {
                min = now.t;
                break;
            }
            //사방탐색
            for (int d = 0; d < 4; d++) {
                int nr = now.r + rr[d];
                int nc = now.c + rc[d];
                int hasSword = now.sword;

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if(hasSword == 0) {
                        if(visited[nr][nc][0] || board[nr][nc] == 1) continue;
                        if(board[nr][nc] == 2) hasSword++;
                    }
                    else {
                        if(visited[nr][nc][1]) continue;
                    }
                    visited[nr][nc][hasSword] = true;
                    que.add(new Warrior(nr,nc,now.t+1,hasSword));
                }
            }


        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        visited = new boolean[N][M][2];

        for (int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < M; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }//입력받기
        }

        min = 0;

        bfs();

        if (min == 0) System.out.println("Fail");
        else System.out.println(min);


    }

}
