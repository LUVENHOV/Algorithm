import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[][] arr;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V= Integer.parseInt(st.nextToken());

        arr = new int[N+1][N+1];
        visited = new boolean[N+1];

        for(int i = 0 ; i < M ; i ++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = arr[b][a] =  1;
        }
        //sb.append("\n");
        dfs(V);
        sb.append("\n");
        visited = new boolean[N+1];

        bfs(V);

        System.out.println(sb);

    }
    public static void dfs(int V) {

        visited[V] = true;
        sb.append(V + " ");

        for(int i = 0 ; i <= N ; i++) {
            if(arr[V][i] == 1 && !visited[i])
                dfs(i);
        }

    }

    public static void bfs(int V) {
        Queue<Integer> que = new LinkedList<>();
        que.add(V);
        visited[V] = true;

        while(!que.isEmpty()) {

            V = que.poll();
            sb.append(V + " ");

            for(int i = 1 ; i <= N ; i++) {
                if(arr[V][i] == 1 && !visited[i]) {
                    que.add(i);
                    visited[i] = true;
                }
            }
        }


    }

}