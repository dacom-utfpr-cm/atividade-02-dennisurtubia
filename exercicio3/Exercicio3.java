package exercicio3;

/**
  * Program that show Prime Numbers between 0 - 100.000.
    Threads are created based on the number of processors
  * @author Dennis Urtubia
  */

class ShowPrimeNumbers extends Thread {
    int startIndex, finalIndex;

    public ShowPrimeNumbers(int startIndex, int finalIndex) {
        this.startIndex = startIndex;
        this.finalIndex = finalIndex;
    }

    @Override
    public void run() {
        startIndex = (startIndex < 2) ? 2 : startIndex;

        for (int i = startIndex; i < finalIndex; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++)
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }

            if (isPrime) System.out.println(i + " is Prime");
        }
    }
}

public class Exercicio3 {
    public static void main(String[] args) {
        int cores = Runtime.getRuntime().availableProcessors();
        int totalNumbers = 100000;
        int qtByPartitions = totalNumbers / cores;

        for (int i = 0; i < cores; i++) {
            int startIndex = (qtByPartitions * i) + 1;
            int endIndex = qtByPartitions * (i + 1);
            new ShowPrimeNumbers(startIndex, endIndex).start();
        }


    }
}
