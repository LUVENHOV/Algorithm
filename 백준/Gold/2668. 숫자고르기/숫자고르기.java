import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static int n, num;
    static int[] arr;
    static boolean[] checked;
    static List<Integer> list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        checked = new boolean[n];
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine())-1;
        }
        list = new LinkedList<>();

        for (int i = 0; i < n ; i++) {
            checked[i] = true;
            num = i;
            dfs(i);
            checked[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(Integer i:list) {
            System.out.println(i+1);
        }
    }
    public static void dfs(int i) {
        if(arr[i]==num) list.add(num);
        if(!checked[arr[i]]) {
            checked[arr[i]] = true;
            dfs(arr[i]);
            checked[arr[i]]=false;
        }
    }
}