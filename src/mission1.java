import java.util.*;

public class mission1 {
    public static void main(String[] args) {
        System.out.println("Введите размер матриц:");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] matrix = new int[n][n];

        rand(n, matrix);
        output(n, matrix);

        Queue<Integer> queue = new LinkedList<>();
        int[] vis = new int[n];
        for (int i = 0; i < n; i++)
            vis[i] = 10000;
        System.out.println();
        System.out.println("Введите вершину:");
        Scanner in1 = new Scanner(System.in);
        int v = in1.nextInt() - 1;

        BFSD(n, v, vis, queue, matrix);

        for (int i = 0; i < n; i++)
            System.out.println(vis[i] + " ");
    }

    public static void rand(int n, int[][] matrix) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (int) ((Math.random() * 2) + 0);
                //matrix[j][i] = matrix[i][j]; // Отвечает за не ориентированность графа

                if (i == j) {
                    matrix[i][j] = 0;
                }
                if (matrix[i][j] == 1) {
                    matrix[i][j] = (int) (Math.random() * 10);
                    //matrix[j][i] = matrix[i][j]; // Отвечает за не ориентированность графа
                }
            }
        }
    }

    public static void output(int n, int[][] matrix) {
        System.out.println("\nМатрица 1:\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void BFSD(int n, int v, int[] vis, Queue<Integer> queue, int[][] matrix){
        vis[v] = 0;
        queue.offer(v);
        while (queue.peek() != null){
            int s = queue.poll();
            //System.out.print(s + 1 + " ");
            for (int i = 0; i < n; i++){
                if (matrix[s][i] > 0 & vis[i] > vis[s] + matrix[s][i]){
                    queue.offer(i);
                    vis[i] = vis[s] + matrix[s][i];
                }
            }
        }
    }
}
