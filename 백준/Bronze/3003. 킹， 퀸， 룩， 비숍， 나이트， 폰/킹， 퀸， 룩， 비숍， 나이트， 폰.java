import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] origin = {1,1,2,2,2,8};
		int[] chess = new int[6];
		int[] ans = new int[6];
		
		
		for(int i = 0; i < chess.length; i++) {
			chess[i] =  sc.nextInt();
		}
		
		for(int i = 0; i < chess.length; i++) {
			ans[i] = origin[i] - chess[i];
		}
		
		for(int i = 0; i < chess.length; i++) {
			System.out.print(ans[i] + " ");
		}
		
	}
	
}
