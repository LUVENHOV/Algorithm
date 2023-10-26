import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N,M,max;
	static int[][] map;
	static int[][] virusmap;
	static int[] rr = {1,-1,0,0};
	static int[] rc = {0,0,-1,1};
	
	static class Node{
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
		
	}
	
	static void BFS() {
		Queue<Node> que = new LinkedList<>();
		//벽이 세워질 때마다 벽 초기화해야하므로 새로운 벽 복사
		virusmap = new int[N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				virusmap[i][j] = map[i][j];
				if(virusmap[i][j] == 2) {
					que.add(new Node(i,j));
				}
				
			}
		}
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			
			for(int i = 0 ; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];
				
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && virusmap[nr][nc] == 0) {
					virusmap[nr][nc] = 2;
					que.add(new Node(nr,nc));
				}
			}
			
		}
		//0인 곳 세기
		int count = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(virusmap[i][j] == 0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);
	}
	
	static void DFS(int wallcount) {
		if(wallcount == 3) {
			//벽이 3개가 되면 바이러스 퍼뜨리기
			BFS();
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j< M; j++) {
				if(map[i][j] == 0) {
					//선택
					map[i][j] = 1;
					DFS(wallcount+1);
					//원복
					map[i][j] = 0;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		max = Integer.MIN_VALUE;
		//전체 0중에서 3개 골라서 벽 세우기~ 맵 전체를 탐색하면서 
		DFS(0);
		
		System.out.println(max);
	}//main
	
	
}
