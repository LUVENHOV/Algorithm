import java.util.*;
class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int[] rr = {0,0,-1,1};
        int[] rc = {1,-1,0,0};
        for(int i = 0; i < 4; i++){
            int nr = h + rr[i];
            int nc = w + rc[i];
            
            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board.length){
                if (board[h][w].equals(board[nr][nc])) answer++;
            }
        }
        
        return answer;
    }
}