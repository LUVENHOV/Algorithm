import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int R = Integer.parseInt(inputs[0]);
        int C = Integer.parseInt(inputs[1]);
        int N = Integer.parseInt(inputs[2]);

        char[][] board = new char[R][C];
        int[][] bomb = new int[R][C];

        for (int i = 0; i < R; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = tmp.charAt(j);
                if(board[i][j]=='O'){
                    bomb[i][j] = 3;
                }
            }
        }

        int time = 0;
        int[] rr = {1, -1, 0, 0};
        int[] rc = {0, 0, 1, -1};

        while(time++ < N) {

            if(time%2==0) {
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (board[r][c] == '.') {
                            board[r][c] = 'O';
                            bomb[r][c] = time+3;
                        }
                    }
                }
            }else if(time%2==1) {
                for (int r = 0; r < R; r++) {
                    for (int c = 0; c < C; c++) {
                        if (bomb[r][c] == time) {
                            board[r][c] = '.';
                            for (int d = 0; d < 4; d++) {
                                int nr = r + rr[d];
                                int nc = c + rc[d];

                                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;

                                if(board[nr][nc]=='O' && bomb[nr][nc] != time) {
                                    board[nr][nc] = '.';
                                    bomb[nr][nc] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }


        for (int i = 0; i < R; i++) {
            System.out.println(board[i]);
        }

    }
}