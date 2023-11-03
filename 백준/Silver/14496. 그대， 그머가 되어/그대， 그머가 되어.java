import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int a,b,N,M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	static class Node{
		int number, cnt;

		public Node(int number, int cnt) {
			this.number = number;
			this.cnt = cnt;
		}
		
	}

	
	static int bfs(int start) {
		Queue<Node> que = new LinkedList<>();
		visited[a] = true;
		que.add(new Node(a,0));
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			if(now.number == b) {
				return now.cnt;
			}
			
			for(int i : list[now.number]) {
				if(visited[i]) continue;
				visited[i] = true;
				que.add(new Node(i, now.cnt+1));
			}
		}
		return -1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N+1];
		
		list = new ArrayList[N+1];
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			list[num1].add(num2);
			list[num2].add(num1);
		}
		
		System.out.println(bfs(a));
		
	}
}
