package baekjoon._17298;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


public class Main {
    public static void main(String[] args) throws IOException {
        int[] array = read();
        int size = array.length;
        Stack<Integer> rightStack = new Stack<>();
        rightStack.add(-1);
        int[] resultArray = new int[size];
        resultArray[size - 1] = -1;
        int beforeIndex = size - 1;
        for (int i = size - 2; i >= 0; i--) {
            if (array[i] < array[beforeIndex]) {
                rightStack.add(array[beforeIndex]);
                resultArray[i] = array[beforeIndex];
            } else {
                int result = -1;
                while (rightStack.size() > 0) {
                    int beforeOkinsu = rightStack.peek();
                    if (beforeOkinsu > array[i]) {
                        result = beforeOkinsu;
                        break;
                    }
                    rightStack.pop();
                }
                resultArray[i] = result;
            }
            beforeIndex = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(resultArray[i]).append(" ");
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
