import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Callable<Integer> myCallable = new MyCallable();
        Callable<Integer> myCallable2 = new MyCallable();
        Callable<Integer> myCallable3 = new MyCallable();
        Callable<Integer> myCallable4 = new MyCallable();

        List<Callable<Integer>> list = new LinkedList<>();
        list.add(myCallable);
        list.add(myCallable2);
        list.add(myCallable3);
        list.add(myCallable4);

        final ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        System.out.println(executorService.invokeAny(list));

        executorService.shutdown();
    }
}
