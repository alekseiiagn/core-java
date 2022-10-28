package corejava.chapter5.lab8;

import java.util.concurrent.locks.ReentrantLock;

public class GeneralLock {
    private static final ReentrantLock REENTRANT_LOCK = new ReentrantLock();

    public static AutoCloseable lock() {
        REENTRANT_LOCK.lock();
        return createAutoCloseable(REENTRANT_LOCK);
    }

    public static AutoCloseable lock(ReentrantLock reentrantLock) {
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
