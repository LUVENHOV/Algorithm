import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int N;
    public static int M;
    public static int J;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        J = Integer.parseInt(br.readLine());

        int bucket = M;

        int[] arr = new int[J];

        for (int i = 0; i < J; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int res = 0;

        for (int i = 0; i < J; i++) {
            int now = arr[i];
            int tmp = 0;
            if (now > bucket) {
                tmp += now - bucket;
                bucket += tmp;

            } else if (now <= bucket - M) {
                tmp += bucket - M + 1 - now;
                bucket -= tmp;
            }

            res += tmp;
        }

        System.out.println(res);
    }
}