import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    static int num;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        num = Integer.parseInt(br.readLine());

        arr = new int[num];
        visited = new boolean[num +1];


        dfs(0);
    }

    public static void dfs(int cnt){
        if(cnt == num){
            for(int x : arr){
                System.out.print(x+" ");
            }
            System.out.println();
            return;
        }
        for(int i=1; i<= num; i++){
            if(!visited[i]){
                visited[i] = true;
                arr[cnt] = i;
                dfs(cnt+1);
                visited[i] = false;
            }
        }
    }
}