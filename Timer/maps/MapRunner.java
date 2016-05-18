package maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MapRunner {

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

        // Thread for the HashTableMap
        Thread HashTableMap = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    HashTableRunner.main(arg);
                    times[0] = HashTableRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

        // Thread for the LinkedHashMap
        Thread LinkedHashMap = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    LinkedHashMapRunner.main(arg);
                    times[1] = LinkedHashMapRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Thread for the TreeMap
        Thread TreeMap = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    TreeMapRunner.main(arg);
                    times[2] = TreeMapRunner.time();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        // Starts HashTable
        System.out.println("\tHashTableMap");
        HashTableMap.start();
        while (HashTableMap.isAlive()) {
        }

        // Starts LinkedHashMap
        System.out.println("\tLinkedHashMap");
        LinkedHashMap.start();
        while (LinkedHashMap.isAlive()) {
        }

        // Starts TreeMap
        System.out.println("\tTreeMap");
        TreeMap.start();
        while (TreeMap.isAlive()) {
        }
    }

    public static double[][] time() {
        return times;
    }
}