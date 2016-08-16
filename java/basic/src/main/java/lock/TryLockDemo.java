package lock;
/**
 * Created by lichuangjian on 16/7/27.
 * desprition:
 */

import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockDemo {
    private final ReentrantLock lock;

    public TryLockDemo() {
        lock = new ReentrantLock();
    }

    public static void main(String[] args) throws InterruptedException {
        final TryLockDemo lockDemo = new TryLockDemo();
        Runnable runnable = new Runnable() {
            public void run() {
                if (lockDemo.lock.tryLock()) {
                    System.out.println(String.format("%s %s locked", new Date(System.currentTimeMillis()), Thread.currentThread().getName()));
                }
            }
        };
        Thread threadA = new Thread(runnable, "Thread A");
        Thread threadB = new Thread(runnable, "Thread B");

        threadA.start();
        threadB.start();
    }
}