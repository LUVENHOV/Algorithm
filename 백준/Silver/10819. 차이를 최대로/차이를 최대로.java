import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static int N;
    public static int[] nums;
    public static int[] res;
    public static boolean[] visited;
    public static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        res = new int[N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);
        System.out.println(ans);
    }

    public static void dfs(int cnt){
        if(cnt == N) {
            int sum = 0;
            for(int i = 0; i < N - 1; i++) {
                sum += Math.abs(res[i] - res[i+1]);
            }
            ans = Math.max(ans, sum);
            return;
        }
        for(int i = 0; i < N; i++) {
            if(!visited[i]){
                res[cnt] = nums[i];
                visited[i] = true;
                dfs(cnt + 1);
                visited[i] = false;
            }
        }
    }
}
