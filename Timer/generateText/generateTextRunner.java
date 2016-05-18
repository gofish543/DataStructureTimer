package generateText;

import java.io.FileWriter;
import java.io.IOException;

public class generateTextRunner {

    public static void main(String[] args) throws IOException {
        // The string to be put into the file
        String file = "";
        // Opens the file writer
        FileWriter write = new FileWriter("Timer\\MassiveFile.txt");
        // Random numbers between 65 and 122 for ASCII
        for (int index = 1; index <= 100000; index++) {
            int one = (int) ((Math.random() * 57) + 65);
            int two = (int) ((Math.random() * 57) + 65);
            int three = (int) ((Math.random() * 57) + 65);
            char one1 = (char) one;
            char two1 = (char) two;
            char three1 = (char) three;
            String line = "" + one1 + two1 + three1;
            file += line;
            System.out.println(line);
            if (index != 100000)
                file += "\n";
        }

        // Writes and closes the file
        write.write(file);
        write.close();
    }
}