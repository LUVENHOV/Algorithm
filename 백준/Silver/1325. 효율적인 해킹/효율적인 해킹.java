import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[] rank;
	
	static void bfs(int num) {
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		que.add(num);
		visited[num] = true;
		
		while(!que.isEmpty()) {
			int now = que.poll();
			for(int i : list[now]) {
				if(!visited[i]) {
					visited[i] = true;
					rank[i]++;
					que.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		rank = new int[N+1];
		
		
		for(int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			//단방향
			list[a].add(b);
			
		}
		//1부터 N까지 돌면서 
		for(int i = 1; i <= N; i++) {
			bfs(i);
		}
		
		int answer = 0;
		
		for(int i = 1; i <= N; i++) {
			answer = Math.max(answer, rank[i]);
		}
		
		for(int i = 1; i <= N; i++) {
			if(answer == rank[i]) sb.append(i + " ");
		}
		
		System.out.println(sb);
		
	}
}