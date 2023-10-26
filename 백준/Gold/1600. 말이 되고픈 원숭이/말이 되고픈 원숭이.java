import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int K, W, H, min_dis;
	static int[][] board;
	static boolean[][][] visited;
	static int[] rr = { 0, 0, -1, 1 };
	static int[] rc = { 1, -1, 0, 0 };
	static int[] hr = new int[] { 2, 2, 1, 1, -1, -1, -2, -2 };
	static int[] hc = new int[] { 1, -1, 2, -2, 2, -2, 1, -1 };

	static class Node {
		int r, c, horse, cnt;

		public Node(int r, int c, int horse, int cnt) {
			this.r = r;
			this.c = c;
			this.horse = horse;
			this.cnt = cnt;
		}

	}

	static void MONKEY() {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(0, 0, 0, 0));
//		visited[0][0][0] = true;

		while (!que.isEmpty()) {
			Node now = que.poll();

			// 맨 오른쪽 아래에 도착하면 최솟값 갱신
			if (now.r == H - 1 && now.c == W - 1) {
				min_dis = Math.min(min_dis, now.cnt);
			}
			// 먼저 사방탐색
			for (int i = 0; i < 4; i++) {
				int nr = now.r + rr[i];
				int nc = now.c + rc[i];
				// 맵 내부에서 0이면 이동 가능
				if (nr >= 0 && nc >= 0 && nr < H && nc < W && board[nr][nc] == 0
						&& !visited[nr][nc][now.horse]) {
					for (int j = now.horse; j < K+1; j++) { // 현재 말부터 더 위까지 전부 방문처리
						visited[nr][nc][j] = true;
					}
					que.add(new Node(nr, nc, now.horse, now.cnt + 1));
				}
			}

			if (now.horse < K) {
				for (int i = 0; i < 8; i++) {
					int nr = now.r + hr[i];
					int nc = now.c + hc[i];
					if (nr >= 0 && nc >= 0 && nr < H && nc < W && board[nr][nc] == 0
							&& !visited[nr][nc][now.horse + 1]) {
						for (int j = now.horse + 1; j < K + 1; j++) {
							visited[nr][nc][j] = true;
						}
						que.add(new Node(nr, nc, now.horse + 1, now.cnt + 1));
					}
				}
			}

		} // que

	}// MONKEY

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken()); // 가로길이
		H = Integer.parseInt(st.nextToken()); //세로길이
		board = new int[H][W];
		visited = new boolean[H][W][K + 1];

		for (int i = 0; i < H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < W; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min_dis = Integer.MAX_VALUE;

		MONKEY();
		
		if(min_dis == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min_dis);
	}
}
