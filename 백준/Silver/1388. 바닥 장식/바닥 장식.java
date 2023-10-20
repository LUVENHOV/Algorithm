import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, M,count;
	static char[][] board;
	static boolean[][] visited;

	// 가로 개수 찾는 bfs
	static void bfs(int r, int c) {
		//들어갔다면 얘는 탐색된 적 없으므로 count를 늘려주고
		//얘를 기준으로 가로 혹은 세로를 탐색해본다
		Queue<Node> que = new LinkedList<>();
		visited[r][c] = true;
		que.add(new Node(r,c));
		count++;
		
		while(!que.isEmpty()) {
			Node now = que.poll();
			int nr = now.r;
			int nc = now.c;
			
			//들어온 값이 - 이면 column 증가
			if(board[r][c] == '-') {
				nc ++;
			//들어온 값이 | 이면 row 증가
			} else nr ++;
			
			//범위 벗어나면 continue
			if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;
			
			//확인 값과 다음 값이 같으면( - or |) count를 세지 말고 node에 넣고 방문처리
			//bfs에 들어오는 조건 자체가 !visited 이므로 처리한 애는 bfs에 안 들어옴
			if(board[r][c] == board[nr][nc]) {
				que.add(new Node(nr,nc));
				visited[nr][nc] = true;
			}
			
		}
		
	}


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		// 맵 전체를 탐색하여 개수 세기
		// 방문처리 되지 않으면 bfs 돌려보기
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					bfs(i,j);						
				}
			}
		}
		
		System.out.println(count);

	}// main

}
