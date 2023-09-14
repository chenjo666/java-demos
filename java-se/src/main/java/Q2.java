import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(in.nextInt());
        }

        while (!queue.isEmpty()) {
            int p = queue.poll();
            if (!queue.isEmpty()) {
                queue.offer(queue.poll());
            }
            System.out.print(p + " ");
        }
    }
}
