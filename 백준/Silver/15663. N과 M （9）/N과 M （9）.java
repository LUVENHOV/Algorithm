import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] num;
    static int[] ans;
    static boolean[] visited;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        num = new int[N];
        visited = new boolean[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i<N; i++)
            num[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(num);

        dfs(0);
    }

    static void dfs(int cnt){
        if(cnt == M){
            for(int i = 0; i<M; i++)
                System.out.print(ans[i]+" ");

            System.out.println();
        }

        else{
            int temp = 0;
            for(int i = 0; i<N; i++){
                if(visited[i])
                    continue;

                if(temp != num[i]){
                    visited[i] = true;
                    ans[cnt] = num[i];
                    temp = num[i];
                    dfs(cnt+1);
                    visited[i] = false;
                }
            }
        }
    }
}