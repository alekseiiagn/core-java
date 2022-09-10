package corejava.chapter5.lab8;

import java.util.concurrent.locks.ReentrantLock;

public class GeneralLock {
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static AutoCloseable lock() {
        REENTRANT_LOCK.lock();
        return createAutoCloseable();
    }

    private static AutoCloseable createAutoCloseable() {
        return new AutoCloseable() {
            public void close() {
                try {
                    if (REENTRANT_LOCK.isLocked())
                        REENTRANT_LOCK.unlock();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
