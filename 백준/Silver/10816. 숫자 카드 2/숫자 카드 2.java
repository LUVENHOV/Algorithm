import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static int lowerBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (key <= arr[mid]) {
				end = mid;
			} else
				start = mid + 1;
		}
		return start;
	}

	public static int upperBound(int[] arr, int key) {
		int start = 0;
		int end = arr.length;
		while (start < end) {
			int mid = (start + end) / 2;
			if (key < arr[mid]) {
				end = mid;
			} else
				start = mid + 1;
		}
		return start;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int key = Integer.parseInt(st.nextToken());

			sb.append(upperBound(arr, key) - lowerBound(arr, key)).append(' ');
		}
		System.out.println(sb);
	}
}
