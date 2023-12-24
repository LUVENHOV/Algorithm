import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a1,b1,a2,b2;

        st = new StringTokenizer(br.readLine());

        a1=Integer.parseInt(st.nextToken());
        b1=Integer.parseInt(st.nextToken());

        int sum=0;

        for(int i=0;i<N-1; i++) {

            st = new StringTokenizer(br.readLine());
            a2= Integer.parseInt(st.nextToken());
            b2 = Integer.parseInt(st.nextToken());

            if(b1>=b2) {
                continue;
            }else if(b1>=a2) {
                b1=b2;
            }else {
                sum+=Math.abs(b1-a1);
                a1=a2;
                b1=b2;
            }
        }
        sum+=Math.abs(b1-a1);

        System.out.println(sum);
    }
}
