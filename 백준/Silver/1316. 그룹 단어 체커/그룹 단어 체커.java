import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws  Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt  = 0;

        for(int  i = 0; i < N; i++){
            if(check(br.readLine())){
                cnt++;
            }
        }
        br.close();
        System.out.println(cnt);
    }

    static boolean check(String str){

        boolean[] alphabet = new boolean[26];
        int prev = -1;

        for(int i = 0; i < str.length(); i++){
            int now = str.charAt(i);

            if(prev != now){
                if(!alphabet[now - 97]){

                    alphabet[now-97] = true;
                    prev = now;

                }else{
                    return false;
                }
            }
        }
        return true;
    }
}