import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G;
    static int[] move;
    static int[] dir = new int[2];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        move = new int[F +1];
        bfs(S);

    }

    static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] check = new boolean[F +1];

        que.add(start);
        check[start] = true;
        move[start] = 0;

        while(!que.isEmpty()) {
            int now = que.poll();
            if(now == G) {
                System.out.println(move[now]);
                return;
            }

            for(int i=0; i<2; i++) {
                int next = now + dir[i];

                if(next > F || next <1 ) continue;

                if(!check[next]) {
                    check[next] = true;
                    que.add(next);
                    move[next]= move[now]+1;
                }
            }
        }

        System.out.println("use the stairs");

    }
}