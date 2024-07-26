import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");

        int N = Integer.parseInt(str[0]);
        int K = Integer.parseInt(str[1]);

        int[][] arr = new int[N][3];

        for(int i = 0; i < N; i++){
            str = br.readLine().split(" ");

            int tmp = Integer.parseInt(str[0])-1;

            for(int j = 0; j < 3; j++){
                arr[tmp][j] = Integer.parseInt(str[j+1]);
            }
        }

        int cnt = 1;

        for(int i = 0; i < N; i++){
            if(i == K-1)
                continue;
            else{
                if(arr[i][0] > arr[K-1][0]){
                    cnt++;
                    continue;
                }
                else if(arr[i][0] == arr[K-1][0]){
                    if(arr[i][1] > arr[K-1][1])
                        cnt++;
                    else if(arr[i][1] == arr[K-1][1]){
                        if(arr[i][2] > arr[K-1][2])
                            cnt++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}