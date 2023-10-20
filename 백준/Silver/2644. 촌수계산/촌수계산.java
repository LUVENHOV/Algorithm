import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n, m, p1, p2, res;
	static ArrayList<Integer>[] list;
	static boolean[] visited;

	static void dfs(int start, int cnt) {
		if(start == p2) {
			res = cnt;
			return;
		}
		
		visited[start] = true;
		for(int i : list[start]) {
			if(!visited[i]) {
				dfs(i, cnt+1);
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		p1 = Integer.parseInt(st.nextToken());
		p2 = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i = 1; i < n+1; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		res = -1;
		
		dfs(p1,0);
		
		System.out.println(res);
		
	}
}
