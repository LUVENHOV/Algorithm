import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<Integer,String> map1 = new HashMap<>();
        HashMap<String,Integer> map2 = new HashMap<>();

        for(int i=1;i<=N;i++) {
            String str = br.readLine();
            map1.put(i, str);
            map2.put(str, i);
        }

        for(int i=0;i<M;i++) {
            String s = br.readLine();
            if(49 <= s.charAt(0) && s.charAt(0) <= 57) {
                int key = Integer.parseInt(s);
                sb.append(map1.get(key));
            }
            else {

                sb.append(map2.get(s));
            }

            sb.append("\n");



        }
        System.out.println(sb);
    }

}