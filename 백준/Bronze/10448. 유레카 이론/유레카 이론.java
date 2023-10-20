import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int N;
	static int[] tri;

	static boolean check(int n) {
		for (int i = 1; i < 45; i++) {
			for (int j = 1; j < 45; j++) {
				for (int k = 1; k < 45; k++) {
					if(tri[i] + tri[j] + tri[k] == n) return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		tri = new int[45];

		for (int i = 1; i < 45; i++) {
			tri[i] = (i * (i + 1)) / 2;
		} // 삼각수 배열 저장

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			
			if(check(N)) {
				System.out.println(1);
			} else System.out.println(0);

		} // tc

	}

}
