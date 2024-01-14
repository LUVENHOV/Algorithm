import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int r;
    int c;

    Node(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static final int rr[] = {0,0,1,-1};
    static final int rc[] = {1,-1,0,0};
    static ArrayList<Node> list = new ArrayList<>();
    static boolean visited[][];
    static int board[][];
    static int N,L,R,cnt;
    static boolean transfer = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        board = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        move();

        System.out.println(cnt);

    }
    static void move() {

        while(true) {
            transfer = false;
            visited = new boolean[N][N];

            for(int i=0; i<N; i++) {
                for(int j=0;j<N; j++) {
                    if(!visited[i][j]){
                        bfs(i,j);
                    }
                }
            }

            if(!transfer) break;
            else cnt++;
        }

    }

    static void bfs(int r, int c) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r,c));
        visited[r][c] = true;
        list.add(new Node(r,c));

        while(!que.isEmpty()) {
            Node now = que.poll();
            r = now.r;
            c = now.c;

            for(int d=0; d<4; d++) {
                int nx = r + rr[d];
                int ny = c + rc[d];

                if(0<=nx && nx<N && 0<=ny && ny<N) {
                    if(!visited[nx][ny] && L <= Math.abs(board[r][c] - board[nx][ny]) &&  Math.abs(board[r][c] - board[nx][ny]) <= R) {
                        transfer = true;
                        visited[nx][ny] = true;
                        list.add(new Node(nx,ny));
                        que.add(new Node(nx,ny));
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0; i<list.size(); i++) {
            Node p = list.get(i);
            sum += board[p.r][p.c];
        }

        for(int i=0; i<list.size(); i++) {
            Node p = list.get(i);
            board[p.r][p.c] = sum / list.size();
        }
        list.removeAll(list);
    }
}