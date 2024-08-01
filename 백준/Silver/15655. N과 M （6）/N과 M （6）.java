import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        comb(0, new int[M], 0);
        System.out.print(sb);
    }

    static void comb(int cnt, int[] visited, int start) {
        if(cnt == M) {
            for(int i=0;i<cnt;i++) {
                sb.append(visited[i]).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start;i<N;i++) {
            visited[cnt]= arr[i];
            comb(cnt+1, visited, i+1);
        }
    }
}