import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int max = Integer.MIN_VALUE;
    public static int min = Integer.MAX_VALUE;
    public static int[] oper = new int[4];
    public static int[] num;
    public static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        num = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        dfs(num[0], 1);

        System.out.println(max);
        System.out.println(min);

    }

    public static void dfs(int num, int idx) {
        if (idx == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            //연산자 개수 체크(1개 이상)
            if (oper[i] > 0) {

                //해당 연산자 1 감소
                oper[i]--;

                switch (i) {

                    case 0:	dfs(num + Main.num[idx], idx + 1);	break;
                    case 1:	dfs(num - Main.num[idx], idx + 1);	break;
                    case 2:	dfs(num * Main.num[idx], idx + 1);	break;
                    case 3:	dfs(num / Main.num[idx], idx + 1);	break;

                }
                oper[i]++;
            }
        }
    }

}