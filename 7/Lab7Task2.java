import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lab7Task2 {

    public static void main(String[] args) throws Exception {

        int[][] matrix = {
                {3, 5, 12, 7},
                {24, 99, 11, 4},
                {8, 14, 0, 33}
        };






        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<Integer>> futures = new ArrayList<>();


        for (final int[] row : matrix) {
            futures.add(executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    int localMax = Integer.MIN_VALUE;
                    for (int val : row) {
                        if (val > localMax) {
                            localMax = val;
                        }
                    }
                    return localMax;
                }
            }));
        }

        int globalMaxVar2 = Integer.MIN_VALUE;
        for (Future<Integer> future : futures) {
            int rowMax = future.get();
            if (rowMax > globalMaxVar2) {
                globalMaxVar2 = rowMax;
            }
        }

        executor.shutdown();
        System.out.println("Максимум в матрице (Вариант 2): " + globalMaxVar2);
    }


}
