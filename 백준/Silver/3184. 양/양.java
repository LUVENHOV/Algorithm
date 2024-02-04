import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static boolean[][] visited;
    static int R, C, total_wolf, total_sheep, wolf, sheep;
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,-1,0,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        total_wolf = 0;
        total_sheep = 0;

        arr = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            String input = br.readLine();
            for(int j = 0; j< C; j++){
                arr[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i< R; i++){
            for(int j = 0; j< C; j++){
                wolf = 0;
                sheep = 0;
                if(!visited[i][j]) {
                    if(arr[i][j] == 'v' || arr[i][j] == '.' || arr[i][j] == 'o') {
                        dfs(i, j);
                    }
                }
                if(sheep > wolf){
                    wolf = 0;
                }else{
                    sheep = 0;
                }
                total_wolf += wolf;
                total_sheep += sheep;
            }
        }
        System.out.println(total_sheep + " " + total_wolf);
    }

    private static void dfs(int r, int c){
        visited[r][c] = true;

        if(arr[r][c] == 'o'){
            sheep += 1;
        }else if(arr[r][c] == 'v'){
            wolf += 1;
        }

        for(int i = 0; i< 4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(nr >= 0 && nc >= 0 && nr < R && nc < C){
                if(!visited[nr][nc]){
                    if(arr[nr][nc] == '.' || arr[nr][nc] == 'v' || arr[nr][nc] == 'o'){
                        dfs(nr, nc);
                    }
                }
            }
        }
    }
}