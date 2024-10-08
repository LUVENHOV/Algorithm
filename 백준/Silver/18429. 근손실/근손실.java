import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int ans;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[N];

        for(int i=0; i< N; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        visited =new boolean[N];
        ans =0;
        dfs(500, 0);

        System.out.println(ans);

    }

    public static void dfs(int sum, int cnt){
        if(cnt == N){
            ans++;

            return;
        }
        for(int i=0; i< N; i++){
            if(!visited[i] && sum+arr[i]- K >= 500) {
                visited[i]=true;

                dfs(sum+arr[i]- K, cnt+1);
                visited[i]=false;
            }
        }
    }
}