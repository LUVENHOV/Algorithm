import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min_dis;
	static int[][] board;
	static boolean visited[][][];
	static int[] rr = { -1, 1, 0, 0 };
	static int[] rc = { 0, 0, -1, 1 };

	static class Node {
		int r, c, cnt, punch;

		public Node(int r, int c, int punch, int cnt) {
			this.r = r;
			this.c = c;
			this.punch = punch;
			this.cnt = cnt;
		}
	}

	static void BFS() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0, 0, 1));
		visited[0][0][0] = true;

		while (!que.isEmpty()) {
			Node now = que.poll();

			if (now.r == N - 1 && now.c == M - 1) {
				min_dis = Math.min(min_dis, now.cnt);
			}

			for (int i = 0; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];
				// 맵 내부에서~
				if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
					if (visited[nr][nc][now.punch])
						continue;

					// 다음 이동하는 곳이 0이라 부술 필요가 없는 경우
					if (board[nr][nc] == 0) {
						// 방문 처리
						visited[nr][nc][now.punch] = true;
						que.add(new Node(nr, nc, now.punch, now.cnt + 1));
					}
					// 다음 이동하는 곳이 1이고 punch질 안했다면
					else if (board[nr][nc] == 1 && now.punch == 0) {
						visited[nr][nc][1] = true;
						que.add(new Node(nr, nc, 1, now.cnt + 1));
					}
				}
			}
		} // que

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j) - '0';
			}
		}

		min_dis = Integer.MAX_VALUE;

		BFS();

		if (min_dis == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(min_dis);
		}

	}

}
