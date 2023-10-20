import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int N = Integer.parseInt(str);
		int N_len = str.length();
		int answer = 0;
				
		//범위 설정하기
		//0부터 탐색이 아닌 N부터 (N의 길이 * 9) 이전부터 탐색하면 됨
		//1~9까지의 값들이 각 자리수에 입력되어 (0은 더해도 영향 x므로) 더해지기 때문에 가능
		//999의 경우 999-27인 972+(9+9+9) 만 가능 -> 더해질 수 있는 max 값이 27인 것!
		for(int i = N-(N_len * 9); i < N; i++) {
			
			if (i <= 0) continue;
			
			int now = i;
			int sum = 0;
			
			while(now != 0) {
				sum += now % 10;
				now /= 10;
			}
			
			if(sum + i == N) {
				answer = i;
				break;
			}
			
		}
		System.out.println(answer);
	}

}
