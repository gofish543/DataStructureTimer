package hashTables;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;
import timer.TimerMilli;
import timer.TimerNano;

public class HashTableRunner {

    private static double[] times = new double[2];

    @SuppressWarnings("unchecked")
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
            args = new String[] { x };
        }

        // Sets up the timer object
        TimerMilli time = new TimerMilli();

        // Sets up the HashTable and the reader
        LinkedList<String>[] hashTable = new LinkedList[58];
        Scanner read = new Scanner(new FileReader("Timer\\MassiveFile.txt"));

        // Starts the timer
        time.setStart(System.currentTimeMillis());

        // Adds each line into the HashTable
        while (read.hasNext()) {
            String x = read.next();
            if (hashTable[x.substring(0, 1).hashCode() - 65] == null) {
                hashTable[x.substring(0, 1).hashCode() - 65] = new LinkedList<String>();
                hashTable[x.substring(0, 1).hashCode() - 65].add(x);
            } else {
                hashTable[x.substring(0, 1).hashCode() - 65].add(x);
            }
        }

        // Stops the timer
        time.setEnd(System.currentTimeMillis());

        // Closes the file reader
        read.close();

        // ****************************************************\\
        // Difference from start to finish
        long diff = time.getDifference();

        // Conversions to nanoseconds, milliseconds, seconds, and minutes
        // double nanoseconds = diff * 1000000.0;
        double milliseconds = diff;
        // double seconds = (diff / 1000.0);
        // double minutes = ((diff / 1000.0) / 60.0);

        // Prints out the time for each
        // System.out.println("The ArrayList lab took " + (double) nanoseconds +
        // " nanoseconds");
        System.out.println("\tTime to add " + (int) milliseconds + " milliseconds");
        // System.out.println("The ArrayList lab took " + (double) seconds + "
        // seconds");
        // System.out.println("The ArrayList lab took " + (double) minutes + "
        // minutes");
        // System.out.println("-------------------------------------------------");

        // Now finds the random value and times it
        TimerNano t = new TimerNano(System.nanoTime());
        hashTable[args[0].substring(0, 1).hashCode() - 65]
                .get(hashTable[args[0].substring(0, 1).hashCode() - 65].indexOf(args[0]));
        t.setEnd(System.nanoTime());

        double milli = t.getDifference() / (double) 1000000.0;

        // Prints out the time
        System.out.println("\tTime to get " + milli + " milliseconds");
        // System.out.println("==========================================================");
        times[0] = milliseconds;
        times[1] = milli;
    }

    public static double[] time() {
        return times;
    }
}