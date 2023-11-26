import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static class Node {
		int start;
		int value;

		Node(int start, int value) {
			this.start = start;
			this.value = value;
		}
	}

	static ArrayList<Node>[] board; // 지름길 정보를 저장하기 위한 리스트

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 0부터 시작해서 D에 도착해야함
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] distance = new int[D + 1];
		
		board = new ArrayList[10001];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for (int i = 0; i < 10001; i++) {
			board[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int value = Integer.parseInt(st.nextToken());

			// 지름길이 무조건으로 최단거리는 아님. -> 지름길인 경우만 저장한다.
			if (end - start > value) {
				board[end].add(new Node(start, value));
			}
		}

		distance[0] = 0;
		for (int i = 1; i <= D; i++) {
			if (board[i].size() > 0) {
				for (Node start : board[i]) {
					if (distance[start.start] + start.value > distance[i])
						continue;
					distance[i] = Math.min(distance[i - 1] + 1, distance[start.start] + start.value);
				}
				continue;
			}
			distance[i] = distance[i - 1] + 1;
		}

		System.out.println(distance[D]);

	}
}