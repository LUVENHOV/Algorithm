import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M,count;
	static ArrayList<Integer>[] adjList;
	static boolean[] visited;
	
	static void dfs(int Node) {
		//시작하는 노드 방문처리
		visited[Node] = true;
		//해당 Node에 해당하는 i들 중에서~
		for(int i : adjList[Node]) {
			//방문하지 않았다면~
			if(!visited[i]) {
				//방문처리하고
				count++;
				//연결된 거니까 count 세주고
				dfs(i);
				//해당 노드에 연결된 애 다시 dfs 탐색
			}
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		adjList = new ArrayList[N+1];
		visited = new boolean[N+1];
		
		for(int i = 1; i < N+1; i++) {
			adjList[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M ;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjList[a].add(b);
			adjList[b].add(a);
		}
		//1번 NODE 탐색
		dfs(1);
		
		System.out.println(count);
		
	}
	
}
