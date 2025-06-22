package thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // klt thread work : 1624ms
//        Threads.workCpuBoundThread();
//        ult thread work : 1496ms
  //      VirtualThreads.workCpuBoundVThread();

        // CPU BOUND 연산에서 vthread와 kthread의 차이는 크지 않다
        // vthread의 장점은 IO bound에서 나온다

        //workIOBoundMockThread time: 2427ms
        //Thread Count: 10000
        //workIOBoundMockThread time: 6063ms
        //Thread Count: 20000
        Threads.workIOBoundMockThread();

        //workIOBoundMockVThread time: 1940ms
        //VThread Count: 10000
//        workIOBoundMockThread time: 5808ms
//        Thread Count: 20000
//        VirtualThreads.workIOBoundMockVThread();
    }
}
