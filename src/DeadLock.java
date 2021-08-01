import java.util.LinkedList;

public class DeadLock {
    public static final String obj1 = "obj1";
    public static final String obj2 = "obj2";
    public static void main(String[] args){
        new Thread(() -> {
                while(true) {
                    synchronized (DeadLock.obj1){
                        System.out.println("get lock " + obj1);
                        try {
                            Thread.sleep(3000);
                            synchronized (DeadLock.obj2){
                                System.out.println("get lock " + obj2);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        new Thread(() -> {
                while(true) {
                    synchronized (DeadLock.obj2){
                        System.out.println("get lock " + obj2);
                        try {
                            Thread.sleep(3000);
                            synchronized (DeadLock.obj1){
                                System.out.println("get lock " + obj1);
                            }
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
           }).start();
    }
}

