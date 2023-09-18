import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_그래프의삼각형 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int[][] adjArr = new int[N + 1][N + 1]; // 1번~N개의 정점 번호를 이용한다고 가정

			// 간선 정보 입력 받기

			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();

				adjArr[x][y] = 1; // 양쪽이므로 한쪽만 설정해도 됨
			}

			int ans = 0;

			for (int i = 1; i <= N - 2; i++) {
				for (int j = i + 1; j <= N - 1; j++) {
					for (int k = j + 1; k <= N; k++) {
						if (adjArr[i][j] == 1 && adjArr[j][k] == 1 && adjArr[i][k] == 1)
							ans++;
					}
				}
			}
			System.out.println("#" + test_case + " " + ans);
		}
	}
}