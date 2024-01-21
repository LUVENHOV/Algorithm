class Solution {
    public int solution(int[] bandage, int health, int[][] attacks){
        int max = health;
        int ex_attack = 0;

        for(int[] attack : attacks){
            //붕대감기
            int current = attack[0] - 1 - ex_attack;
            int heal = (current * bandage[1] + (current / bandage[0]) * bandage[2]);

            //health가 max를 넘지 않도록 설정
            if (health + heal > max) health = max;
            else health += heal;

            //만약 attack으로 피가 다 까이면 -1 반환, 아니면 뺀 값 반환
            if(health > attack[1]) health -= attack[1];
            else return -1;

            ex_attack = attack[0];
        }

        return health;
    }

}