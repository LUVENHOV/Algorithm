import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answersheet;
    static int[] test;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        answersheet = new int[10];
        test = new int[10];

        for (int i = 0; i < 10; i++) {
            answersheet[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        backtrack(0);
        System.out.println(ans);
    }

    static void backtrack(int depth) {
        if (depth == 10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (answersheet[i] == test[i]) {
                    cnt++;
                }
            }
            if (cnt >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (test[depth - 1] == i && test[depth - 2] == i) continue;
            }
            test[depth] = i;
            backtrack(depth + 1);
        }
    }

}