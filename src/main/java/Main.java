import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        Callable<Integer> myCallable4 = new MyCallable();

//        List<Callable> list = new LinkedList<>();
//        list.add(myCallable);
//        list.add(myCallable2);
//        list.add(myCallable3);
//        list.add(myCallable4);


        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
  //      final ExecutorService threadPool = Executors.newFixedThreadPool(4);
//        final Future<Integer> task = threadPool.submit(myCallable);
        final Future<Integer> task = executorService.submit(myCallable);
        final Future<Integer> task2 = executorService.submit(myCallable2);
        List<Future<Integer>> list = new LinkedList<>();
        list.add(task);
        list.add(task2);
        threadPool.submit(myCallable2);
        threadPool.submit(myCallable3);
        threadPool.submit(myCallable4);
        threadPool.invokeAll(list);
  //      final Integer resultOfTask = task.get();
        System.out.println(executorService.invokeAny(task));
        executorService.invokeAll(list);

        executorService.shutdown();
    }
}
