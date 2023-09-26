import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{
//BFS
	static int N, M;
	static int count = 0;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		adjList = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		bfs(1);
		System.out.println(count);
		
	}
	
	static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<>();
		visited = new boolean[N+1];
		visited[start] = true;
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int x : adjList[now]) {
				if(visited[x] == false) {
					visited[x] = true;
					count++;
					queue.add(x);
				}
			}
		}
	}
	
}
