import java.util.*;

class Solution {
    
    public class Node {
        int r,c;
        
        public Node(int r,int c){
            this.r = r;
            this.c = c;
        }
    }
    
    static int[] rr = {-1,1,0,0};
    static int[] rc = {0,0,-1,1};
    
    public int solution(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;
        
        boolean visited[][] = new boolean[N][M];
        visited[0][0] = true;
        
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0,0));
        while(!que.isEmpty()){
            Node now = que.poll();
            
            for(int i = 0; i < 4; i++) {
                int nr = now.r + rr[i];
                int nc = now.c + rc[i];
                
                if(nr >= 0 && nc >= 0 && nr < N && nc < M){
                    //아직 방문하지 않았고 갈 수 있는 길이면: 못 가면 0이니까 0보다 크면
                    if(visited[nr][nc] == false && maps[nr][nc] > 0) {
                        visited[nr][nc] = true;
                        maps[nr][nc] = maps[now.r][now.c] + 1;
                        que.add(new Node(nr,nc));
                    }
                }
            }
        }
        return maps[N-1][M-1] == 1 ? -1 : maps[N-1][M-1];
    }
}

