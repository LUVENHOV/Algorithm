import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, ans;
	static int[][] board;
	//순서 중요! 오 / 대 / 아 => 조건문에서 사용
	static int[] rr = { 0, 1, 1 };
	static int[] rc = { 1, 1, 0 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		board = new int[N ][N ];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ans = 0;
		// 시작점은 보드 기준 (1,2)
		DFS(0, 1, 0);

		System.out.println(ans);
	}

	// direction이 0일 때는 파이프가 가로 방향, 1일 때는 세로 방향, 2일 때는 대각선 방향.
	public static void DFS(int r, int c, int direction) {
		if (r == N-1 && c == N-1) { // 종료 조건
			ans++;
			return;
		}
		//가로: 오/대
		//대각선: 오/대/아
		//세로: 대/아
		for (int d = (direction == 2 ? 1 : 0); d < (direction == 0 ? 2 : 3); d++) {
			int nr = r + rr[d];
			int nc = c + rc[d];
			if(nr < N && nc < N && board[nr][nc] != 1) {
				if(d == 1) {
					//대각선 방향 추가 체크
					if(board[r][nc] == 1 || board[nr][c] == 1) continue;
				}
				DFS(nr, nc, d);
			}
		}
	}

}
