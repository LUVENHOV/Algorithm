import java.util.*;

class Solution {
    public List<Integer> solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        while(i<arr.length){
            //빈 배열이면 arr[i] 추가
            if(list.size() == 0) {
                list.add(arr[i]);
                i++;
            } else if (list.get(list.size()-1) == arr[i]){
                list.remove(list.size()-1);
                i++;
            } else {
                list.add(arr[i]);
                i++;
            }
        }
        if (list.size() == 0) list.add(-1);
        return list;
    }
}