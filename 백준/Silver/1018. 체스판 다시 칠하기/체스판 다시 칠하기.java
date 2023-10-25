import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int N, M, min_count;
	static char[][] board;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}
//		System.out.println(Arrays.deepToString(board));

		// 8*8이니까 커봤자 64
		min_count = 64;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M - 8; j++) {
				int W_count = 0;
				int B_count = 0;
				int current_count = 0;
				for (int r = i; r < i + 8; r++) {
					for (int c = j; c < j + 8; c++) {
						// 1행 1열이 b 라면
						if ((r + c) % 2 == 0 && board[r][c] == 'W')
							W_count++;
						if ((r + c) % 2 == 1 && board[r][c] == 'B')
							W_count++;
						// 1행 1열이 w 라면
						if ((r + c) % 2 == 0 && board[r][c] == 'B')
							B_count++;
						if ((r + c) % 2 == 1 && board[r][c] == 'W')
							B_count++;
					}
				}
				current_count = Math.min(W_count, B_count);
				min_count = Math.min(min_count, current_count);
			}
		}
		System.out.println(min_count);
	}
}
