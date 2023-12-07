import java.util.HashMap;

class Solution {
    HashMap<Character, Integer> map;
    boolean[] visited;
    int[] nums;
    int answer;

    public int solution(int n, String[] data) {
        map = new HashMap<>();
        visited = new boolean[8];
        nums = new int[8];
        answer = 0;

        map.put('A', 0);
        map.put('C', 1);
        map.put('F', 2);
        map.put('J', 3);
        map.put('M', 4);
        map.put('N', 5);
        map.put('R', 6);
        map.put('T', 7);

        dfs(0, data);

        return answer;
    }

    public void dfs(int idx, String[] data) {

        if (idx == 8 && check(data)) answer++;
        else {
            for (int i = 0; i < 8; i++) {

                if (!visited[i]) {
                    visited[i] = true;
                    nums[idx] = i;

                    dfs(idx + 1, data);

                    visited[i] = false;
                }
            }
        }
    }

    public boolean check(String[] data) {

        for (String str : data) {
            int a = nums[map.get(str.charAt(0))];
            int b = nums[map.get(str.charAt(2))];
            int dist = Character.getNumericValue(str.charAt(4)) + 1;

            switch (str.charAt(3)) {
                case '=':
                    if (Math.abs(a - b) != dist) return false;
                    break;
                case '>':
                    if (Math.abs(a - b) <= dist) return false;
                    break;
                case '<':
                    if (Math.abs(a - b) >= dist) return false;
                    break;
            }


        }

        return true;
    }
}