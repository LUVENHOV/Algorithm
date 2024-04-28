import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] board = new int[N+1][N+1];

        //사과 위치 초기화
        for(int i = 0; i<K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            board[r][c] = 1;
        }

        int temp = Integer.parseInt(br.readLine());

        Queue<change> que = new LinkedList<>();
        for(int i = 0; i<temp; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            que.add(new change(time, dir));
        }

        //0 북, 1 동, 2 남, 3 서
        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        //초기 (1, 1)에서 시작하고 동쪽을 보고 시작
        int row = 1;
        int col = 1;
        int time = 0;
        int dir = 1;
        Queue<Node> queue  = new LinkedList<>();
        queue.add(new Node(row, col));
        board[row][col] = 2;

        while(true){
            int nr = row + dr[dir];
            int nc = col + dc[dir];

            time++;

            if(nr<1||nc<1||nr>N||nc>N)
                break;
            if(board[nr][nc] == 2)
                break;

            if(board[nr][nc] == 0){
                Node node = queue.poll();
                board[node.r][node.c] = 0;
            }
            if(!que.isEmpty()) {
                if (time == que.peek().time) {
                    change s = que.poll();

                    if (s.dir.equals("L"))
                        dir = dir-1 < 0 ? 3 : dir-1;
                    if (s.dir.equals("D"))
                        dir = dir+1 > 3 ? 0 : dir+1;
                }
            }

            board[nr][nc] = 2;
            queue.offer(new Node(nr, nc));
            row = nr;
            col = nc;
        }

        System.out.println(time);
    }
}
class change {
    int time;
    String dir;

    change(int time, String dir){
        this.time = time;
        this.dir = dir;
    }
}

class Node{
    int r, c;

    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}