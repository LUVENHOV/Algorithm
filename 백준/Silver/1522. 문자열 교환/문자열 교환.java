import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int a_cnt = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a')
                a_cnt++;
        }
        for(int i = 0; i < str.length(); i++){
            int b_cnt = 0;
            for(int j = i; j < a_cnt+i; j++) {
                if(str.charAt(j % str.length()) == 'b')
                    b_cnt++;
            }
            min = Math.min(min, b_cnt);
        }
        System.out.println(min);
    }

}
