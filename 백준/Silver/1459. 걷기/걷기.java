import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long X, Y, W, S;
    static int[][] board;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());
        W = Long.parseLong(st.nextToken()); // 가로/세로 시간
        S = Long.parseLong(st.nextToken()); // 대각선 시간

        long home1, home2, home3;

        //가로, 세로로만 걷는 경우
        home1 = (X + Y) * W;

        //대각선으로만 이동하는 경우
        //1. 짝수일 경우 : 큰 값의 크기만큼 대각선이동
        if((X + Y) % 2 ==0) home2 = Math.max(X,Y) * S;
        //2. 홀수인 경우 : (큰 값의 크기 - 1) 만큼 이동 후 가로/세로 이동 1번
        else home2 = (Math.max(X,Y)-1) * S + W;

        //대각선으로 최대 이동 후 가로,세로 이동
        //작은값만큼 대각선 이동 후 두 수의 차만큼 가로/세로 이동
        home3 = (Math.min(X,Y)) * S + (Math.abs(X-Y)) * W;

        System.out.println(Math.min(home1, Math.min(home2, home3)));
    }
}
