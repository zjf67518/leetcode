public class MutiThread {

    public static void main(String[] args) {
        PrintABC printABC = new PrintABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    printABC.printA();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    printABC.printB();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    printABC.printC();
                }
            }
        }).start();
    }
}

class PrintABC {
    private volatile int value = 3;
    void printA(){
        synchronized (this) {
            while(value != 1) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("A");
            value = 2;
            this.notifyAll();
        }
    }
    void printB(){
        synchronized (this) {
            while(value != 2) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("B");
            value = 3;
            this.notifyAll();
        }
    }
    void printC(){
        synchronized (this) {
            while(value != 3) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C");
            value = 1;
            this.notifyAll();
        }
    }
}
