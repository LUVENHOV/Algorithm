import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

    static char[][] board;
    static char[][] bomb;
    static int[] rr = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] rc = {-1, 0, 1, 1, 1, 0, -1, -1};
    static boolean flag = false;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        bomb = new char[N][N];

        //지뢰 위치 입력받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                bomb[i][j] = str.charAt(j);
            }
        }

        //열린 칸, 안 열린 칸 위치 입력받기
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(board[i][j] == 'x'){
                    if(bomb[i][j] == '*')
                        flag = true;
                    else {
                        bombCnt(i, j);
                    }
                }
                else
                    board[i][j] = '.';
            }
        }

        if(flag) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(bomb[i][j] == '*')
                        board[i][j]= '*';
                }
            }
        }

        for (char[] chars : board) {
            for (char aChar : chars) {
                sb.append(aChar);
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }


    private static void bombCnt(int i, int j) {
        int count = 0;

        for (int k = 0; k < 8; k++) {
            int x = i + rr[k];
            int y = j + rc[k];
            if(0 <= x && x <= N -1 && 0 <= y && y <= N -1){
                if(bomb[x][y] == '*')
                    count++;
            }
        }
        board[i][j] = (char) (count + '0');
    }

}