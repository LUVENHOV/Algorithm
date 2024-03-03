import java.util.ArrayList;

class Solution {

    public long solution(String expression) {
        long answer = Long.MIN_VALUE;
        //조합 가능한 연산 배열
        String ops[][] = {{"+", "-", "*"}, {"-", "+", "*"},
                {"+", "*", "-"}, {"-", "*", "+"},
                {"*", "-", "+"}, {"*", "+", "-"}};

        ArrayList<String> list = new ArrayList<>();

        int index = 0;
        for(int i = 0; i < expression.length(); i++){
            if(expression.charAt(i) == '-' || expression.charAt(i) == '+'
            || expression.charAt(i) == '*'){
                list.add(expression.substring(index, i)); //연산자 앞 숫자 list에 추가
                list.add(expression.charAt(i) + ""); // 연산자 list에 추가
                index = i + 1; //연산자 다음으로 index 이동
            }
        }
        list.add(expression.substring(index)); //마지막 숫자 list에 추가

        //ops 를 돌면서 가장 큰 절댓값을 가지는 수를 answer로
        for (int i = 0; i < ops.length; i++){
            ArrayList<String> opList = new ArrayList<>(list);
            for (int j =0; j < 3; j++){
                for(int k = 0; k < opList.size(); k++){
                    if(ops[i][j].equals(opList.get(k))) {
                        opList.set(k-1, cal(opList.get(k-1), opList.get(k), opList.get(k+1)));
                        opList.remove(k);
                        opList.remove(k);
                        k--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(opList.get(0))));
        }

        return answer;
    }

    private static String cal(String num1, String op, String num2) {

        if(op.equals("+")) return Long.parseLong(num1) + Long.parseLong(num2) + "";
        else if(op.equals("-")) return Long.parseLong(num1) - Long.parseLong(num2) + "";
        return Long.parseLong(num1) * Long.parseLong(num2) + "";
    }

}
