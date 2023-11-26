import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
	static int[] res;
	static boolean[] visited;
	
	static void dfs(int node) {
		visited[node] = true;
		for(int i : arr.get(node)) {
			if(!visited[i]) {
				dfs(i);
				res[i] = node;
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList<ArrayList<Integer>>();
		
		for(int i = 0; i <= N; i++) arr.add(new ArrayList<>());
		
		for(int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			arr.get(num1).add(num2);
			arr.get(num2).add(num1);
		}
		
		visited = new boolean[N+1];
		res = new int[N+1];
		
		dfs(1);
		
		for(int i = 2; i < res.length; i++) {
			System.out.println(res[i]);
		}
		
	}
}
