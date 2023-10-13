import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

	static class Node {
		int r, c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int N, min_count;
	static int[][] board;
	static boolean[][] visited;
	static int[][] ans;
	static int[] rr = { -1, 1, 0, 0 };
	static int[] rc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<Node> queue = new LinkedList<>();

		queue.add(new Node(0, 0));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			Node now = queue.poll();
			int r = now.r;
			int c = now.c;
			// 마지막 종착지에 도착하면 min 값 갱ㅇ신
			if (r == N - 1 && c == N - 1) {
				min_count = Math.min(min_count, ans[N - 1][N - 1]);
			}

			// 시간 초과 줄이기
			if (min_count <= ans[r][c])
				continue;

			for (int i = 0; i < 4; i++) {
				int nr = r + rr[i];
				int nc = c + rc[i];
				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {//맵을 벗어나지 않을 때
					if (!visited[nr][nc] || ans[r][c] + board[nr][nc] < ans[nr][nc]) {
						//1. 방문하지 않았거나(첫 방문)
						//2. 방문했더라도 앞서서 방문 시 저장한 값보다 작으면~!! 중요~~~
						visited[nr][nc] = true;
						ans[nr][nc] = ans[r][c] + board[nr][nc];
						queue.add(new Node(nr, nc));
					}
				}

			}

		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			N = sc.nextInt();
			board = new int[N][N];

			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					board[i][j] = str.charAt(j) - '0';
				}
			}

			min_count = Integer.MAX_VALUE;
			visited = new boolean[N][N];

			ans = new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			ans[0][0] = 0;

			bfs();
			System.out.println("#" + tc + " " + min_count);
		}

	}

}
