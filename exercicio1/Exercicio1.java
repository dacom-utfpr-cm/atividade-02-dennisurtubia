package exercicio1;

/**
  * Create thread that monitoring state of a thread group.
  * @author Dennis Urtubia
  */

class Monitor extends Thread {
    Thread[] threads;

    public Monitor(Thread[] threads) {
        this.threads = threads;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                for (int i = 0; i < threads.length; i++) {
                    System.out.println(threads[i].getState());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}

class InfiniteThread extends Thread {
    @Override
    public void run() {
        while (true) {
            if (Thread.interrupted()) {
                break;
            }
        }
    }
}

class SleepThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Exercicio1 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[4];

        threads[0] = new InfiniteThread();
        threads[0].start();

        threads[1] = new InfiniteThread();
        threads[1].start();
        threads[1].interrupt();

        threads[2] = new InfiniteThread();

        threads[3] = new SleepThread();
        threads[3].start();

        new Monitor(threads).start();
    }
}
