package thread;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Threads {

    public static int workCpuBoundThread() {

        long start = System.currentTimeMillis();
        AtomicInteger count = new AtomicInteger();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 50_000_000; i++) {
                count.addAndGet(i % 10);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 50_000_000; i++) {
                count.addAndGet(i % 10);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        long time = end - start;

        System.out.println("count: " + count.get());
        System.out.println("klt thread work : " + time + "ms");
        return count.get();
    }

    public static void workIOBoundMockThread() throws InterruptedException {
        long start = System.currentTimeMillis();
        try (ExecutorService es = Executors.newFixedThreadPool(100)){
            CountDownLatch latch = new CountDownLatch(1000);

            for (int i = 0; i < 1000; i++) {
                es.submit(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    } finally {
                        latch.countDown();
                    }
                });
            }

            latch.await();

            long end = System.currentTimeMillis();
            System.out.println("workIOBoundMockThread time: " + (end - start));
        }
    }
}
