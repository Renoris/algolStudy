package baekjoon._17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_fail {
    //38% 실패
    //2중 for문
    public static void main(String[] args) throws IOException {
        int[] array = read();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            int targetNumber = array[i];
            int result = -1;
            for (int j = i + 1; j < array.length; j++) {
                if (targetNumber < array[j]) {
                    result = array[j];
                    break;
                }
            }
            sb.append(result).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static int[] read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] array = new int[size];

        String[] secondLine = br.readLine().split(" ");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(secondLine[i]);
        }

        return array;
    }
}
