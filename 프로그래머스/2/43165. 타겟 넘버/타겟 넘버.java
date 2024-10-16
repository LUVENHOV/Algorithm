class Solution {
    
    static int answer = 0;
    
    public int solution(int[] numbers, int target) {
        
        DFS(0, numbers, target, 0);
                    
        return answer;
    }
        
        private void DFS(int depth, int[] numbers, int target, int sum){
            if(depth == numbers.length){
                if(target == sum) {
                    answer++;
            }
            return;
        }
        DFS(depth+1, numbers, target, sum + numbers[depth]);
        DFS(depth+1, numbers, target, sum - numbers[depth]);
    }
}