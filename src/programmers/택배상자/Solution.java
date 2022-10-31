package programmers.택배상자;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int result = 0;
        Stack<Integer> rightStack = new Stack<>();
        Stack<Integer> leftStack = new Stack<>();

        //기존 컨베이어벨트구성
        for (int i = order.length; i >= 1; i--) {
            rightStack.add(i);
        }

        //기사가 원하는 박스찾기
        for (int i = 0; i < order.length; i++) {
            int target = order[i];
            if (rightStack.size() > 0){
                while (rightStack.size() > 0) {
                    if (leftStack.size() > 0 && leftStack.peek() == target) {
                        leftStack.pop();
                        result++;
                        break;
                    }
                    if (rightStack.peek() == target) {
                        rightStack.pop();
                        result++;
                        break;
                    } else {
                        leftStack.add(rightStack.pop());
                    }
                }
            } else {
                if (leftStack.size() > 0 &&  leftStack.peek() == target) {
                    result++;
                    leftStack.pop();
                }else {
                    break;
                }
            }
        }



        return result;
    }
}