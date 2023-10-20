import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
	
	static boolean flag = false;
	static int[] dwarfs;
	static int[] answer;
	
	static void combination(int index, int ansindex, int count) {
		
		if(flag) return;
		
		if(ansindex == 7) {
			if(count == 100) {
				Arrays.sort(answer);
				for(int i = 0; i < answer.length; i++) {
					System.out.println(answer[i]);
				}
				flag = true;
			}
			return;
		}
		
		if(index == 9) return;
		if(count > 100) return;
		
		answer[ansindex] = dwarfs[index];
		combination(index+1, ansindex+1, count + dwarfs[index]);
		combination(index+1, ansindex, count);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		dwarfs = new int[9];
		answer = new int[7];
		
		for(int i = 0; i < 9; i++) {
			dwarfs[i] = Integer.parseInt(br.readLine());
		}
		
		combination(0,0,0);
		
	}
	
}
