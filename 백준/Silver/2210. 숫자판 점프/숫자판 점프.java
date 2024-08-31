import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int [][] board;
    public static int[] rr = { 0, 0, -1, 1 };
    public static int[] rc = { -1, 1, 0, 0 };
    public static int [] ans;
    public static ArrayList<String> list;
    public static void main(String[] args ) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        board = new int [5][5];
        ans = new int [6];

        for (int i = 0; i < 5; i++) {
            st=new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new ArrayList<>();
        for(int i = 0 ; i < 5 ; i++)
            for(int j = 0 ; j < 5 ; j++)
                dfs(i,j,1);


        System.out.println(list.size());
    }

    public static void dfs(int r, int c , int depth) {

        if(depth > 6) {

            StringBuilder str = new StringBuilder();
            for (int an : ans)
                str.append(Integer.toString(an));

            if(list.indexOf(str.toString()) < 0)
                list.add(str.toString());
            return;
        }

        ans[depth-1] = board[r][c];

        for(int i = 0 ; i < 4 ; i ++) {
            int nr = r + rr[i];
            int nc = c + rc[i];

            if(nr>=0 && nr<5 && nc>=0 && nc<5)
                dfs(nr,nc,depth+1);

        }
    }
}