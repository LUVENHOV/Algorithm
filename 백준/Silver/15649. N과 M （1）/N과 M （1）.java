import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	static void permutation(int depth, String str) {
		
		if(depth == M) {
			sb.append(str.trim()).append("\n");
			return;
		}
		
		for(int i = 1; i < N+1; i++) {
			if(!visited[i]) {
				visited[i] = true;
				permutation(depth+1, str + " " + i);
				visited[i] = false;
				
			}
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		
		permutation(0, "");
		
		System.out.println(sb);

	}

}
