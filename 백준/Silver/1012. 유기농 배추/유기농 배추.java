import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
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

	static void bfs(int r, int c) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(r, c));

		while (!que.isEmpty()) {
			Node now = que.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];
				// 맵 범위 설정
				if (nr < 0 || nc < 0 || nr >= N || nc >= M)
					continue;
				// 조건 설정
				if (visited[nr][nc] || board[nr][nc] == 0)
					continue;
				visited[nr][nc] = true;
				que.add(new Node(nr, nc));

			}
		}
		count++;

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
						visited[i][j] = true;
						bfs(i, j);
					}
				}
			}
			System.out.println(count);
		} // tc
	}

}
