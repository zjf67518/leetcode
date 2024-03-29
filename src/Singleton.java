public class Singleton {
    private volatile static Singleton singleton;
    private  Singleton() {
    }
    public static Singleton createSingleton () {
        if(singleton == null) {
            synchronized (Singleton.class) {
                if(singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
