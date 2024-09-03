import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    static int N, M;
    static int [] changes;
    static int [] arr;
    static int [] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N +1];
        changes = new int[N +1];

        String[] str1 = br.readLine().split(" ");

        for(int i=1; i<= N; i++){
            arr[i] = Integer.parseInt(str1[i-1]);
        }

        String[] str2 = br.readLine().split(" ");

        for(int i=1; i<= N; i++){
            changes[i] = Integer.parseInt(str2[i-1]);
        }

        for(int i=0; i< M; i++){
            temp = new int[N +1];

            for(int j=1; j<= N; j++){
                temp[changes[j]] = arr[j];
            }
            arr = temp;
        }

        for(int i=1; i<= N; i++){
            System.out.print(arr[i]+" ");
        }
    }

}
