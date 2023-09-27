import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

	static int M, N, K, count;
	static int[][] map;
	static int[] rr = { 0, 0, -1, 1 };
	static int[] rc = { 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][M];

		for (int i = 0; i < K; i++) {
			int r1 = sc.nextInt();
			int c1 = sc.nextInt();
			int r2 = sc.nextInt();
			int c2 = sc.nextInt();

			for (int j = c1; j < c2; j++) { // column이 가로길이
				for (int k = r1; k < r2; k++) { // row가 세로길이
					map[j][k] = 1;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					count = 0;
					dfs(i,j);
					list.add(count);
				}
			}
		}
		Collections.sort(list);
		
		System.out.println(list.size());
		for(int i = 0; i< list.size(); i++) {
			System.out.print(list.get(i) + " " );
		}
		
	}

	static void dfs(int r, int c) {
		map[r][c] = 1;
		count++;

		for (int i = 0; i < 4; i++) {
			int nr = r + rr[i];
			int nc = c + rc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc] == 0) {
				dfs(nr, nc);
			}
		}

	}

}
