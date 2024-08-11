import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] rr = {-1,1,0,0};
    static int[] rc = {0,0,-1,1};

    static int R,C;
    static char[][] board;
    static Queue<int[]> que = new ArrayDeque<>();
    static boolean flag = false;   // 늑대가 양이 있는 칸으로 갈 수 있는지 판단하는 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];

        for(int i = 0 ; i < R ; i++) {
            char[] ch = br.readLine().toCharArray();
            for(int j = 0 ; j < C ; j++) {
                board[i][j] = ch[j];

                if(board[i][j] == 'W') que.add(new int[] {i,j});
            }
        }

        bfs();

        if(flag) {
            System.out.println(0);
            return;
        }

        System.out.println(1);
        for(int i = 0 ; i < R ; i++) {
            for(int j = 0 ; j < C ; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void bfs() {
        while(!que.isEmpty()) {
            int[] now = que.poll();

            for(int d = 0 ; d < 4 ; d++) {  // 늑대 이동
                int nx = now[0] + rr[d];
                int ny = now[1] + rc[d];

                if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
                    if(board[nx][ny] == '.') {    // 빈칸이면 울타리 설치
                        board[nx][ny] = 'D';
                    }
                    if(board[nx][ny] == 'S') {    // 양이면 종료
                        flag = true;
                        return;
                    }
                }
            }
        }
    }
}