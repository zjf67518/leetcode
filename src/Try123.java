public class Try123 {
    private static int i = 1;

    public static void main(String[] args) {
        Try123 t = new Try123();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 50; j++) {
                    t.print1();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 50; j++) {
                    t.print2();
                }
            }
        }).start();
    }

    private void print1() {
        synchronized (this) {
            while (i % 2 != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ji:" + i++);
            this.notifyAll();
        }
    }

    private void print2() {
        synchronized (this) {
            while (i % 2 != 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("ou:" + i++);
            this.notifyAll();
        }
    }
}
