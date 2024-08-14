import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    // static 변수 선언
    static int M;
    static char[][] star;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        M = (N-1)*4+1;
        star = new char[M][M];

        for(int i=0; i<M; i++) {
            Arrays.fill(star[i], ' ');
        }

        drawStar(N, 0, 0);

        for(int i=0; i<M; i++) {
            for(int j=0; j<M; j++) {
                sb.append(star[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void drawStar(int num, int r, int c) {
        int size = (num - 1) * 4 + 1;

        if(num == 1) {
            star[r][c] = '*';
            return;
        }
        
        for(int i = 0; i < size; i++) {
            star[r][c + i] = '*';
            star[r + size - 1][c + i] = '*';
            star[r + i][c] = '*';
            star[r + i][c + size - 1] = '*';
        }
        
        drawStar(num - 1, r + 2, c + 2);
    }
}
