import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
    int r,c,count;
    public Pair(int r, int c, int count) {
        this.r = r;
        this.c = c;
        this.count = count;
    }
}

public class Main {
    static int N,M,oneCnt,max;
    static int[] rr = {0,0,1,-1};
    static int[] rc = {1,-1,0,0};
    static int[][] board;
    static boolean[][] visited;
    static Queue<Pair> que = new LinkedList<>();

    public static void bfs() {
        int current = 0;
        while (!que.isEmpty()) {

            Pair now = que.poll();
            current++;

            for (int d = 0; d < 4; d++) {

                int nr = now.r + rr[d];
                int nc = now.c + rc[d];

                if(nr < N && nc < M && nr >= 0 && nc >= 0){
                    if(board[nr][nc]==1 && !visited[nr][nc]){
                        que.add(new Pair(nr,nc,current+1));
                        visited[nr][nc]=true;
                    }
                }
            }
        }
        max = Math.max(max, current);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        oneCnt = 0;
        max = 0;
        board = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(board[i][j] == 1 && ! visited[i][j]){
                    oneCnt++;
                    visited[i][j] = true;
                    que.add(new Pair(i,j,1));
                    bfs();
                }
            }
        }
        System.out.println(oneCnt);
        System.out.println(max);
    }
}