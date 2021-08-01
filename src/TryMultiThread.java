public class TryMultiThread {
    private static volatile int i = 1;

    public static void main(String[] args) {
        TryMultiThread demo = new TryMultiThread();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i <= 100) {
                    demo.print1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(i <= 100) {
                    demo.print2();
                }
            }
        }).start();
    }

    public void print1() {
        synchronized (this) {
            while (i % 2 == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i <= 100) {
                System.out.println(i++);
            }
            this.notifyAll();
        }
    }

    public void print2() {
        synchronized (this) {
            while (i % 2 == 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if(i <= 100) {
                System.out.println(i++);
            }
            this.notifyAll();
        }
    }

}
