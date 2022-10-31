import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int finish;
    private static int count;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        read();
        int[] array = new int[count];
        boolean[] check = new boolean[finish];
        for (int i = 0; i < finish; i++) {
            tracking(i, array, check, 0);
        }

        System.out.println(sb.toString());
    }

    private static void tracking(int num, int[] array, boolean[] check, int nowCount) {
        check[num] = true;
        array[nowCount] = num + 1;
        if (nowCount == count - 1) {
            for (int i = 0; i < count; i++) {
                sb.append(array[i]).append(" ");
            }
            sb.append("\n");
            check[num] = false;
            return;
        }

        for (int i = 0; i < finish; i++) {
            if (check[i]) continue;
            tracking(i, array, check, nowCount + 1);
        }
        check[num] = false;
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        finish = Integer.parseInt(line[0]);
        count = Integer.parseInt(line[1]);
    }
}
