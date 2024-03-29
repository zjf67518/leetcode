import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
        new Thread(new produce(bq), "producer1").start();
        new Thread(new consume(bq),"consumer1").start();
        new Thread(new consume(bq),"consumer2").start();
        new Thread(new consume(bq),"consumer3").start();
    }
}

class produce implements Runnable {
    private BlockingQueue<Integer> bq;
    public produce(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }
    @Override
    public void run() {
        for(int i = 0; i < 10; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bq.offer(i);
            System.out.println(Thread.currentThread().getName() + "produce: " + i);
        }
    }
}
class consume implements Runnable {
    private BlockingQueue<Integer> bq;
    public consume(BlockingQueue<Integer> bq) {
        this.bq = bq;
    }
    @Override
    public void run() {
        try {
            while(true) {
                //Thread.sleep(310);
                int tmp = bq.take();
                System.out.println(Thread.currentThread().getName() + "consume: " + tmp);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}