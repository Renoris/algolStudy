package baekjoon._1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    private static int[] array;
    private static int[] nums;

    public static void main(String[] args) throws IOException {
        read();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            if (binarySearch(0, array.length - 1, nums[i])) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        }
        System.out.println(sb.toString());
    }

    private static boolean binarySearch(int start, int max, int target) {
        int middle = (start + max) / 2;

        if (start == max) {
            return array[start] == target;
        }

        if (target > array[middle]) {
            return binarySearch(middle + 1, max, target);
        } else {
            return binarySearch(start, middle, target);
        }
    }

    public static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numLength = Integer.parseInt(br.readLine());
        array = new int[numLength];
        String[] secondLines = br.readLine().split(" ");
        for (int i = 0; i < numLength; i++) {
            array[i] = Integer.parseInt(secondLines[i]);
        }

        int arrayLength = Integer.parseInt(br.readLine());
        nums = new int[arrayLength];
        String[] fourthLines = br.readLine().split(" ");
        for (int i = 0; i < arrayLength; i++) {
            nums[i] = Integer.parseInt(fourthLines[i]);
        }
        Arrays.sort(array);
    }
}
