package concurrent;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Desc:
 * ------------------------------------
 * Author:lichuangjian@meituan.com
 * Date: 16/8/21
 * Time: 下午6:32
 */
public class AtomicTest {

    @Test
    public void AtomicReferenceTest() {
        AtomicReference<Integer> atomicReference = new AtomicReference<>();
        atomicReference.set(10);
        System.out.println(atomicReference.compareAndSet(10, 10));
    }

    @Test
    public void AtomicIntegerTest() throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger();
        ExecutorService executorService = Executors.newFixedThreadPool(30);
        List<Callable<Integer>> callableList = Lists.newArrayList();
        for (int i = 0; i < 10000000; i++) {
            callableList.add(atomicInteger::getAndIncrement);
        }
        executorService.invokeAll(callableList);
        System.out.println(atomicInteger.get());
    }
}