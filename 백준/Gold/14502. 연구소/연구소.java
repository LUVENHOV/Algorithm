import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int max = Integer.MIN_VALUE;
	static int[][] board;
	static int[][] virusboard;
	static int[] rr = { -1, 1, 0, 0 };
	static int[] rc = { 0, 0, -1, 1 };

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}

	}

	static void DFS(int count) {
		if (count == 3) {
			BFS();
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 0) {
					board[i][j] = 1;
					DFS(count + 1);
					board[i][j] = 0;
				}
			}
		}

	}// DFS

	static void BFS() {
		Queue<Node> que = new LinkedList<>();
		// 벽을 세울 새로운 맵 생성
		virusboard = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusboard[i][j] = board[i][j];
				if (virusboard[i][j] == 2) {
					que.add(new Node(i, j));
				}
			}
		}

		while (!que.isEmpty()) {
			Node now = que.poll();

			for (int i = 0; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && virusboard[nr][nc] == 0) {
					virusboard[nr][nc] = 2;
					que.add(new Node(nr, nc));
				}
			}

		}
		// 0인 곳 세기
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (virusboard[i][j] == 0) {
					count++;
				}
			}
		}
		max = Math.max(max, count);

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		DFS(0);

		System.out.println(max);

	}

}
