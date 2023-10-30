import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N,S,count;
	static int[] arr;
	
	static void com(int index, int sum) {
		if(index == N) {
			if(sum == S) count++;
			return;
		}
		com(index+1, sum + arr[index]);
		com(index+1, sum);		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr =new int[N];
		
		st= new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		com(0,0);
		
		if (S == 0) System.out.println(count-1);
		else System.out.println(count);
	}
	
}
