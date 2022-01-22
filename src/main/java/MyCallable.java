import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int j = (int) (Math.random() * 10);
        int k = 0;
        for (int i = 0; i < j; i++) {
            Thread.sleep(2500);
            System.out.println(Thread.currentThread().getName() + ". " + "Всем привет!");
            k++;
        }
        return k;
    }
}










//class MyCallable extends Thread {
//
//    public MyCallable(ThreadGroup mainGroup, String name) {
//        super(mainGroup,name);
//    }
//
//    @Override
//    public void run() {
//        try {
//            while(!isInterrupted()) {
//                Thread.sleep(2500);
//                System.out.println(Thread.currentThread().getName() + ". " + "Всем привет!");
//            }
//        } catch (InterruptedException err) {
//
//        } finally{
//            System.out.printf("%s завершен\n", getName());
//        }
//    }
//}