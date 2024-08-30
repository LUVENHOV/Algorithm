import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        char[] arr = str.toCharArray();

        int num1 = 1;
        int num2 = 0;
        char color = arr[0];
        boolean flag = false;

        for(int i=1; i<N; i++) {

            if(arr[i]!=color && !flag) {
                num2++;
                flag = true;
                color = arr[i];
            }else if(arr[i]!=color && flag) {
                num1++;
                flag = false;
                color = arr[i];
            }
        }

        int min = Math.min(num1, num2) + 1;
        System.out.println(min);
    }
}
