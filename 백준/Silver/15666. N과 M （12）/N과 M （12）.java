import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static int[] arr;
    public static int[] nums;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        nums = new int[N];

        st= new StringTokenizer(br.readLine());
        
        for(int i=0; i< N; i++){
            nums[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(0, 0);
        System.out.println(sb);
    }
    
    
    public static void dfs(int cnt, int index) {
        
        if (cnt == M) {
            for (int val : arr) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }
        
        int tmp=0;
        
        for (int i = index; i < N; i++) {
            if(tmp!=nums[i]){
                arr[cnt] = nums[i];
                tmp=nums[i];
                dfs(cnt + 1, i);
            }
        }
    }
}