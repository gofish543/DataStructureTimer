package maps;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import timer.TimerMilli;
import timer.TimerNano;

public class HashTableRunner {

    private static double[] times = new double[2];

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
        Map<Integer, String> list = new Hashtable<Integer, String>();
        Scanner read = new Scanner(new FileReader("Timer\\MassiveFile.txt"));

        // Starts the timer
        time.setStart(System.currentTimeMillis());

        int x = 0;
        // Adds each line into the HashTable
        while (read.hasNext()) {
            list.put(x, read.next());
            x++;
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
        System.out.println("\t\tTime to add " + (int) milliseconds + " milliseconds");
        // System.out.println("The ArrayList lab took " + (double) seconds + "
        // seconds");
        // System.out.println("The ArrayList lab took " + (double) minutes + "
        // minutes");
        // System.out.println("-------------------------------------------------");

        // Now finds the random value and times it
        TimerNano t = new TimerNano(System.nanoTime());
        Object[] key = list.keySet().toArray();
        for (int index = 0; index < key.length; index++) {
            if (list.get(key[index]).equals(args[0])) {
                list.get(key[index]);
                break;
            }
        }
        t.setEnd(System.nanoTime());

        double milli = t.getDifference() / (double) 1000000.0;

        // Prints out the time
        System.out.println("\t\tTime to get " + milli + " milliseconds");
        // System.out.println("==========================================================");
        times[0] = milliseconds;
        times[1] = milli;
    }

    public static double[] time() {
        return times;
    }
}