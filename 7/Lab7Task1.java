import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lab7Task1 {

    public static void main(String[] args) throws Exception {
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = 1;
        }




        int numThreads = 4;
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        List<Future<Integer>> futures = new ArrayList<>();
        int chunkSize = array.length / numThreads;


        for (int i = 0; i < numThreads; i++) {
            final int start = i * chunkSize;
            final int end = (i == numThreads - 1) ? array.length : start + chunkSize;

            futures.add(executor.submit(new Callable<Integer>() {
                @Override
                public Integer call() {
                    int localSum = 0;
                    for (int j = start; j < end; j++) {
                        localSum += array[j];
                    }
                    return localSum;
                }
            }));
        }

        int sumVar2 = 0;
        for (Future<Integer> future : futures) {
            sumVar2 += future.get(); 
        }

        executor.shutdown();
        System.out.println("Итоговая сумма (Вариант 2): " + sumVar2);
    }

}
