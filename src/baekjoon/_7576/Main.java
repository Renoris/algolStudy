package baekjoon._7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    private static int[] moveX = {0, 1, 0, -1};
    private static int[] moveY = {1, 0, -1, 0};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        //7576
        read();
        Queue<Node> queue = searchStartNodes();

        while (queue.size() > 0) {
            Node node = queue.poll();
            int day = map[node.y][node.x];

            for (int i = 0; i < 4; i++) {
                int movedX = moveX[i] + node.x;
                int movedY = moveY[i] + node.y;
                if (!isRange(movedX, movedY)) continue;

                if (map[movedY][movedX] == 0 || map[movedY][movedX] > day + 1) {
                    map[movedY][movedX] = day + 1;
                    queue.add(new Node(movedX, movedY));
                }
            }
        }

        int max = 0;
        for (int i = 0; i < map.length; i++) {
            boolean isFindZero = false;
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 0) {
                    isFindZero = true;
                    break;
                }
                if (map[i][j] > max) {
                    max = map[i][j];
                }
            }
            if (isFindZero) {
                max = -1;
                break;
            }
        }

        if (max > 0) {
            max--;
        }

        System.out.println(max);
    }

    private static boolean isRange(int x, int y) {
        return x >= 0 && x < map[0].length && y >= 0 && y < map.length;
    }

    private static Queue<Node> searchStartNodes() {
        Queue<Node> nodes = new LinkedList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == 1) {
                    nodes.add(new Node(j, i));
                }
            }
        }
        return nodes;
    }

    private static int[][] read() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int x = Integer.parseInt(firstLine[0]);
        int y = Integer.parseInt(firstLine[1]);

        map = new int[y][x];

        for (int i = 0; i < y; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        return map;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

