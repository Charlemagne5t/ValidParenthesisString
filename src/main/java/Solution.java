import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        Queue<Integer> q = new LinkedList<>();
        int open = 0;

        for (int i = 0; i < n; i++) {
            char ch = sb.charAt(i);
            if (ch == '(') {
                open++;
            } else if (ch == '*') {
                q.add(i);
            } else {
                if (open == 0 && q.isEmpty()) {
                    return false;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        int index = q.poll();
                        sb.setCharAt(index, '(');
                    }

                }
            }
        }
        if (open == 0) {
            return true;
        }
        open = 0;
        q = new LinkedList<>();
        for (int i = n - 1; i >= 0; i--) {
            char ch = sb.charAt(i);
            if (ch == ')') {
                open++;
            } else if (ch == '*') {
                q.add(i);
            } else {
                if (open == 0 && q.isEmpty()) {
                    return false;
                } else {
                    if (open > 0) {
                        open--;
                    } else {
                        int index = q.poll();
                        sb.setCharAt(index, ')');
                    }

                }
            }
        }

        return q.size() >= open;

    }
}