import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());

        int A=Integer.parseInt(st.nextToken());
        int B=Integer.parseInt(st.nextToken());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());

        boolean visited[]=new boolean[100001];
        int ans[]=new int[100001];

        Queue<Integer> queue=new LinkedList<>();
        queue.add(N);
        visited[N]=true;

        while(!queue.isEmpty()) {
            int now=queue.poll();
            int arr[]={now - 1,now + 1, now - A,now + A, now - B, now + B, now * A, now * B};
            for(int i = 0; i < 8; i++) {
                if(arr[i] >= 0 && arr[i] < 100001 && !visited[arr[i]]) {
                    visited[arr[i]]=true;
                    ans[arr[i]] = ans[now]+1;
                    queue.add(arr[i]);
                }
            }
            if(ans[M]>0) break;
        }
        System.out.println(ans[M]);
    }
}
