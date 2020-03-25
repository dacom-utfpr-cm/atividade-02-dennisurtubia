package exercicio2;

/**
  * Program that show properties of a ThreadGroup
  * @author Dennis Urtubia
  */


class SomeThread extends Thread {
    public SomeThread(final ThreadGroup group, final String name) {
        super(group, name);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (final InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Exercicio2 {
    public static void main(final String[] args) {
        final ThreadGroup group = new ThreadGroup("Group");

        for (int i = 0; i < 5; i++) {
            new SomeThread(group, "Thread").start();
        }

        System.out.println("Groupe name: " + group.getName());
        System.out.println("Active Threads in group: "+ group.activeCount());
        System.out.println("Active groups in program: "+ group.activeGroupCount());
    }
}