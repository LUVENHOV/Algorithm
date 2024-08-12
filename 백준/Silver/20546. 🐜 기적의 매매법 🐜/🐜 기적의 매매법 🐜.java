import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[14];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < 14 ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int jMoney = N;
        int sMoney = N;
        int jStock = 0;
        int sStock = 0;

        //준현
        for(int i = 0 ; i < arr.length ; i++) {
            if(jMoney / arr[i] > 0) {
                int cnt = jMoney / arr[i];
                jStock += cnt;
                jMoney -= arr[i] * cnt;
            }
        }

        int jTotal = jMoney + arr[arr.length - 1] * jStock;

        //성민
        for(int i = 0 ; i < arr.length - 3 ; i++) {
            if((arr[i] < arr[i + 1]) && (arr[i + 1] < arr[i + 2])) {
                if(sStock == 0) continue;

                sMoney += arr[i + 3] * sStock;
                sStock = 0;
            }
            else if((arr[i] > arr[i + 1]) && (arr[i + 1] > arr[i + 2])) {
                if(sMoney / arr[i + 3] > 0) {
                    int cnt = sMoney / arr[i + 3];
                    sStock += cnt;
                    sMoney -= arr[i + 3] * cnt;
                }
            }
        }

        int sTotal = sMoney + arr[arr.length - 1] * sStock;

        if(jTotal > sTotal) {
            System.out.println("BNP");
        }
        else if(jTotal < sTotal) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }
    }
}