package baekjoon._9663;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //9663 N퀸
    private static int n;
    private static boolean[] columnCheck;
    private static boolean[] lToRUpDiagonal;
    private static boolean[] lToRDownDiagonal;
    private static int result;

    public static void main(String[] args) throws IOException {
        read();
        findPosition(0);
        System.out.println(result);
    }

    private static void findPosition(int y) {
        if (y == n - 1) {
            for (int x = 0; x < n; x++) {
                if (canSetPosition(x, y)) result++;
            }
        } else {
            for (int x = 0; x < n; x++) {
                if (!canSetPosition(x, y)) continue;
                setPosition(x, y);
                findPosition(y + 1);
                resetPosition(x, y);
            }
        }
    }


    private static void setPosition(int x, int y) {
        columnCheck[x] = true;
        lToRUpDiagonal[x + y] = true;
        lToRDownDiagonal[n - 1 - y + x] = true;
    }


    private static boolean canSetPosition(int x, int y) {
        return canSetColumn(x) && canSetLToRUpDiagonal(x,y) && canSetLToRDownDiagonal(x, y);
    }

    private static void resetPosition(int x, int y) {
        columnCheck[x] = false;
        lToRUpDiagonal[x + y] = false;
        lToRDownDiagonal[n - 1 - y + x] = false;
    }

    private static boolean canSetColumn(int x) {
        return !columnCheck[x];
    }

    private static boolean canSetLToRUpDiagonal(int x, int y) {
        return !lToRUpDiagonal[x + y];
    }

    private static boolean canSetLToRDownDiagonal(int x, int y) {
        return !lToRDownDiagonal[n - 1 - y + x];
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        columnCheck = new boolean[n];
        lToRUpDiagonal = new boolean[n * 2 - 1];
        lToRDownDiagonal = new boolean[n * 2 - 1];
    }
}
