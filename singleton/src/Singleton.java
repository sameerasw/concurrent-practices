public class Singleton {
    private volatile static Singleton instance; // must be static since we are using it in the getInstance static method.
    // we mark the variable volatile to prevent cached value for a variable that can change it's value often and can return not up-to-date value.
    // volatile only provides memory visibility.

    public Singleton() {}

    public static Singleton getInstance() {
        // Here, you should use a synchronized block to get the existing instance unless we are creating new instances which is the only part need to be synchronized

        if (instance == null) { // since we are accessing the value outside the lock which makes not always return latest value, we set it as volatile.
            // Since this is a static method, we can not access instances like this, so we use the class name and then .class (runtime of the class)
            synchronized (Singleton.class) {
                // Only if an instance is not present, it will create an object
                if (instance == null) {
                    // We are double-checking to prevent the blocked thread creating another instance once unblocked.
                    instance = new Singleton();
                }
            }
        }


        return instance;
    }

    public void doNothing() {
        System.out.println("doNothing");
    }
}
