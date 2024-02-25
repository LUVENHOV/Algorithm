import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] building;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        building = new int[N];
        answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            building[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N-1; i++){
            answer[i] ++;
            answer[i+1] ++;
            double dif = building[i+1] - building[i];
            for(int j = i+2; j < N; j++){
                double nextDif = (double)(building[j] - building[i])/(j-i);
                if(nextDif <= dif) continue;
                dif = nextDif;
                answer[i]++;
                answer[j]++;
            }
        }

        Arrays.sort(answer);
        System.out.println(answer[answer.length-1]);
    }

}
