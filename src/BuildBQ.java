import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BuildBQ<E> {
    private LinkedList<E> list = new LinkedList<>();

    private ReentrantLock lock = new ReentrantLock();
    private Condition notFullCondition = lock.newCondition();
    private Condition notEmptyCondition = lock.newCondition();

    private int maxSize = 0;

    public BuildBQ(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(E e) throws InterruptedException {
        lock.lock();
        try {
            while(list.size() >= maxSize) {
                notFullCondition.await();
            }
            list.add(e);
            notEmptyCondition.signal();
        } finally {
            lock.unlock();
        }
    }

    public E pop() throws InterruptedException {
        lock.lock();
        try {
            while(list.size() == 0) {
                notEmptyCondition.await();
            }
            E e = list.pop();
            notFullCondition.signal();
            return e;
        } finally {
            lock.unlock();
        }

    }
}
