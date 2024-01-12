class Solution {
    public int solution(String[] spell, String[] dic) {
        boolean wordCheck = false;
        for (String i : dic) {
            int count = 0;
            for (String j : spell) {
                if (i.contains(j)) count++;
            }
            if (count == spell.length) {
                wordCheck = true;
                break;
            }
        }
        return wordCheck ? 1 : 2;
    }
}