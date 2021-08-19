import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Try {
    public static void main(String[] args) {
        BlockingQueue<Integer> bq = new ArrayBlockingQueue<>(10);
        new Thread(new Producer123(bq), "producer1").start();
        //new Thread(new Produce(bq), "producer2").start();
        new Thread(new Comsume(bq, 0), "comsume1").start();
        new Thread(new Comsume(bq, 1), "comsume2").start();
    }
}

class Producer123 implements Runnable{
    private BlockingQueue<Integer> bq;

    public Producer123(BlockingQueue<Integer> bq){
        this.bq = bq;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            try {
                Thread.sleep(100);
                bq.put(i);
                System.out.println(Thread.currentThread().getName()+ "produce" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Comsume implements Runnable{
    private BlockingQueue<Integer> bq;
    private int target;
    public Comsume(BlockingQueue<Integer> bq, int val){
        this.bq = bq;
        this.target = val;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(50);
                if (bq.isEmpty() || bq.peek() % 2 != target) {
                    continue;
                }
                int val = bq.take();
                System.out.println(Thread.currentThread().getName() + "comsume" + val);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}