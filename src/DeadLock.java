
public class DeadLock {
    public static final DeadLock obj1 = new DeadLock();
    public static final DeadLock obj2 = new DeadLock();
    public static void main(String[] args){
        new Thread(() -> {
            synchronized (obj1){
                System.out.println("get lock obj1");
                try {
                    Thread.sleep(3000);
                    synchronized (obj2){
                        System.out.println("get lock obj2");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            }).start();
        new Thread(() -> {
            synchronized (obj2){
                System.out.println("get lock obj2");
                try {
                    Thread.sleep(3000);
                    synchronized (obj1){
                        System.out.println("get lock obj1");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
           }).start();
    }
}

