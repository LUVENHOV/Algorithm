import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        while (N >= 0) {
            if (N % 5 == 0) {
                cnt += N / 5;
                System.out.println(cnt);
                return;
            }
            N -= 2;
            ++cnt;
        }

        System.out.println(-1);
    }
}
