class Solution {
    public int[] solution(int[][] score) {
        
        int length = score.length;
        int[] answer = new int[length];
        int[] avg = new int[length];
        
        for(int i = 0; i < length; i++){
            avg[i] = score[i][0] + score[i][1];
        }
        
        for(int i = 0; i < length; i++){
            int idx = 1;
            for(int j = 0; j < length; j++){
                if(avg[i] < avg[j]){
                    idx++;
                }
            }
            answer[i] = idx;
        }
        
        return answer;
    }
}