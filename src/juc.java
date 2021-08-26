import java.util.concurrent.*;

public class juc {
    public static void main(String[] args) {

        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);
        new Thread(new producer(queue)).start();
        new Thread(new consumer(queue)).start();
        new Thread(new consumer(queue)).start();
        new Thread(new consumer(queue)).start();
    }
}
class consumer implements Runnable{
    private BlockingQueue<Integer> queue;
    public consumer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while(true){
                Thread.sleep(2000);
                int i = queue.take();
                System.out.println("consume " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class producer implements Runnable{
    private BlockingQueue<Integer> queue;
    public producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            for(int i = 0;i<100;i++){
                Thread.sleep(100);
                queue.put(i);
                System.out.println("produce + " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}