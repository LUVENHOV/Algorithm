import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M, K, count;
	static int[][] board;
	static boolean[][] visited;
	static int[] rr = { 0, 0, -1, 1 };
	static int[] rc = { 1, -1, 0, 0 };

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static void dfs(int r, int c) {
		//dfs 들어왔으면 방문처리
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			//사방탐색
			int nr = r + rr[i];
			int nc = c + rc[i];
			// 맵 범위 설정
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			// 조건 설정
			if (visited[nr][nc] || board[nr][nc] == 0)
				continue;
			dfs(nr, nc);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				board[a][b] = 1;
			}

			count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (board[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						// 한 좌표에 대한 dfs가 끝났으면 그게 한 덩어리니까 그 때 카운트!!
						count++;
					}
				}
			}
			System.out.println(count);
		} // tc
	}

}
