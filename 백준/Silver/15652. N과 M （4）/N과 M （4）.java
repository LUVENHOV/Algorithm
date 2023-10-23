import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static StringBuilder sb;
	static boolean[] used;

	static void backtrack(int length, int start, String str) {
		if (length == M) {
			sb.append(str.trim()).append("\n");
			return;
		}

		for (int i = start; i <= N; i++) {
			backtrack(length + 1, i, str + " " + i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		// N, M 입력받기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		// 방문배열 초기화. 사용값이 0부터가 아닌 1부터 N까지이므로 N+1 크기로 생성
		used = new boolean[N + 1];

		// backtrack 시작, start 인자는 1부터!!!
		backtrack(0, 1, "");

		// sb에 모든 str들을 추가했으니까 sb를 출력
		System.out.println(sb);

	}
}
