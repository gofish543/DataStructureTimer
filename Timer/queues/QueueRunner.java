package queues;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class QueueRunner {

    private static double[][] times = new double[2][2];
    private static String[] arg;

    public static void main(String[] args) throws FileNotFoundException {
        // Makes sure args is not null
        if (args.length == 0) {
            int ran = (int) ((Math.random() * 9999) + 1);
            Scanner scan = new Scanner(new FileReader("Timer\\MassiveFile.txt"));
            for (int index = 0; index < ran; index++) {
                scan.next();
            }
            String x = scan.next();
            scan.close();
            arg = new String[] { x };
        } else {
            arg = args;
        }

        // Thread for the LinkedListQueue
        Thread LinkedListQueue = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    LinkedListQueueRunner.main(arg);
                    times[0] = LinkedListQueueRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        // Thread for the PriorityQueue
        Thread PriorityQueue = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    PriorityQueueRunner.main(arg);
                    times[1] = PriorityQueueRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Starts LinkedListQueue
        System.out.println("\tLinkedListQueue");
        LinkedListQueue.start();
        while (LinkedListQueue.isAlive()) {
        }

        // Starts PriorityQueue
        System.out.println("\tPriorityQueue");
        PriorityQueue.start();
        while (PriorityQueue.isAlive()) {
        }
    }

    public static double[][] time() {
        return times;
    }
}