package corejava.chapter5.lab8;

import java.util.concurrent.locks.ReentrantLock;

public class Lab8 {

    public static void main(String[] args) {
        try (AutoCloseable autoCloseable = lock()) {
            System.out.println("Hello world");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static AutoCloseable lock() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        return createAutoCloseable(reentrantLock);
    }

    private static AutoCloseable createAutoCloseable(ReentrantLock reentrantLock) {
        return new AutoCloseable() {
            public void close() {
                try {
                    if (reentrantLock.isLocked())
                        reentrantLock.unlock();
                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        };
    }
}
