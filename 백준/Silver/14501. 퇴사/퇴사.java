import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, res;
    static int[][] schedule;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        schedule = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        } // 입력 받기

        res = 0;
        dfs(0, 0);

        System.out.println(res);
    }

    static void dfs(int idx, int money) {
        if (idx >= N) {
            res = Math.max(money, res);
            return;
        }

        if (idx + schedule[idx][0] <= N)
            dfs(idx + schedule[idx][0], money + schedule[idx][1]);
        else
            dfs(idx + schedule[idx][0], money);


        dfs(idx + 1, money);
    }

}