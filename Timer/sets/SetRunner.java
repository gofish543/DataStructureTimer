package sets;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class SetRunner {

    private static double[][] times = new double[3][2];
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

        // Thread for the LinkedHashSet
        Thread LinkedHashSet = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    LinkedHashSetRunner.main(arg);
                    times[0] = LinkedHashSetRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        // Thread for the HashSet
        Thread HashSet = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    HashSetRunner.main(arg);
                    times[1] = HashSetRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        // Thread for the TreeSet
        Thread TreeSet = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TreeSetRunner.main(arg);
                    times[2] = TreeSetRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Starts LinkedHashSet
        System.out.println("\tLinkedHashSet");
        LinkedHashSet.start();
        while (LinkedHashSet.isAlive()) {
        }

        // Starts HashSet
        System.out.println("\tHashSet");
        HashSet.start();
        while (HashSet.isAlive()) {
        }

        // Starts TreeSet
        System.out.println("\tTreeSet");
        TreeSet.start();
        while (TreeSet.isAlive()) {
        }
    }

    public static double[][] time() {
        return times;
    }
}