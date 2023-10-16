

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N;
	static int M;
	static StringBuilder sb = new StringBuilder();
	
	//첫번째 인자는 길이, 두번째 인자는 뽑아낼 값을 들고 가서 재귀 돌기
	static void permutation(int length, String str) {
		
		//길이가 M이 되면 작성된 str을 stringbuilder에 append
		if(length == M) {
			//trim을 활용하여 스페이스바를 지워주고, \n으로 다음줄에 다음 케이스가 입력되도록 append 추가
			sb.append(str.trim()).append("\n");
			return;
		}
		
		//1부터 N까지 돌면서 사용하지 않은 애들만 재귀하여 추가하도록 작성
		for(int i = 1; i < N+1; i++) {
				//추가한 애는 str에 더해주면서 다음 재귀로 이동
				permutation(length+1, str + " " + i);
				//사용하고 나왔으면 다시 원복해주
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
		//N, M 입력ㅂ다기
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		//permutation 시작
		permutation(0, "");
		
		//sb에 모든 str들을 추가했으니까 sb를 출력
		System.out.println(sb);

	}
}