package thread;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        // klt thread work : 1624ms
//        Threads.workCpuBoundThread();
//        ult thread work : 1496ms
  //      VirtualThreads.workCpuBoundVThread();

        // CPU BOUND 연산에서 vthread와 kthread의 차이는 크지 않다
        // vthread의 장점은 IO bound에서 나온다

        // workIOBoundMockThread time: 10023
//        Threads.workIOBoundMockThread();

        //workIOBoundMockThread time: 1033
        VirtualThreads.workIOBoundMockVThread();
    }
}
