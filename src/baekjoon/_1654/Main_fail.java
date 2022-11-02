package baekjoon._1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_fail {
    //가장 큰 잘린 케이블을 찾지 못함
    private static int[] cable;
    private static int num;

    public static void main(String[] args) throws IOException {
        read();
        long totalCable = 0;
        for (int i = 0; i < cable.length; i++) {
            totalCable += cable[i];
        }

        System.out.println(binarySearch(0, totalCable));
    }

    private static long binarySearch(long start, long max) {
        if (start == max) {
            return start;
        }

        //조건= 최대길이가 필요---
        long middle = (start + max) / 2;

        if (cuttingCable(middle) > num) {
            return binarySearch(middle + 1, max);
        } else {
            return binarySearch(start, middle);
        }
    }

    private static long cuttingCable(long cableDistance) {
        int count = 0;
        for (int i = 0; i < cable.length; i++) {
            count += cable[i] / cableDistance;
        }
        return count;
    }


    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLines = br.readLine().split(" ");
        int cableLength = Integer.parseInt(firstLines[0]);
        cable = new int[cableLength];
        num = Integer.parseInt(firstLines[1]);
        for (int i = 0; i < cableLength; i++) {
            cable[i] = Integer.parseInt(br.readLine());
        }
    }
}
