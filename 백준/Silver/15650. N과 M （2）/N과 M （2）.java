import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int M;
	static boolean[] used;
	static StringBuilder sb;

	static void backtrack(int length, int start, String str) {
		////// 길이가 M이 되면 작성된 str을 stringbuilder에 append
		if (length == M) {
			sb.append(str.trim()).append("\n");
			return;
		}

		// 이번 경우 다음 수가 이전 수보다 크면 안되기 때문에 시작을 i 전체가 아닌 start 부터 하도록 한다
		// backtrack이 돌 때마다 i + 1을 start 인자에 담아서 해당 수부터 시작하도록 한다
		// 이외 내용은 1번과 동일
		for (int i = start; i <= N; i++) {
			if (!used[i]) {
				used[i] = true;
				backtrack(length + 1, i + 1, str + " " + i);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		// N, M 입력ㅂ다기
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
