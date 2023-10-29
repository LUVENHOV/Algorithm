import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	static int N;
	static ArrayList<Long> list;
	static int[] num = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

	static void decrease_num(long n, int index) {
		//배열에 안 담겨 있다면 list에 저장
		if (!list.contains(n))
			list.add(n);
		//탈출조건
		if(index >= 10) return;
		//재귀조건
		decrease_num(n * 10 + num[index], index+1);
		decrease_num(n, index+1);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();

		decrease_num(0, 0);
		Collections.sort(list);
		
		if(N > 1023) System.out.println(-1);
		else System.out.println(list.get(N-1));

	}

}
