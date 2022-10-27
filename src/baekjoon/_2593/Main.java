package baekjoon._2593;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int[] coins;
    private static int goal;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        read();
        dp = new int[goal + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i < dp.length; i++) {
                if (i - coin < 0) continue;
                dp[i] += dp[i - coin];
            }
        }

        System.out.println(dp[goal]);
    }

    private static void read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int coinCount = Integer.parseInt(firstLine[0]);
        coins = new int[coinCount];
        goal = Integer.parseInt(firstLine[1]);

        for (int i = 0; i < coinCount; i++) {
            int line = Integer.parseInt(br.readLine());
            coins[i] = line;
        }
    }
}
