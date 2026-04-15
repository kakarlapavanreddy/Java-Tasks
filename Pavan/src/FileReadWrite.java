import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class FileReadWrite {

    public static void main(String[] args) {

        try {
            // 🔹 Step 1: Create FileWriter object
            FileWriter fw = new FileWriter("data.txt");

            // 🔹 Step 2: Write data into file
            fw.write("Hello Pavan\n");
            fw.write("This is File Handling Example");

            // 🔹 Step 3: Close FileWriter (VERY IMPORTANT)
            fw.close();

            System.out.println("Data written successfully!\n");

            // 🔹 Step 4: Create FileReader object
            FileReader fr = new FileReader("data.txt");

            int ch;

            System.out.println("Reading File Content:\n");

            // 🔹 Step 5: Read file character by character
            while ((ch = fr.read()) != -1) {

                // Convert int → char and print
                System.out.print((char) ch);
            }

            // 🔹 Step 6: Close FileReader
            fr.close();

        } catch (IOException e) {

            // 🔹 Handles file errors
            System.out.println("Error: " + e.getMessage());
        }
    }
}