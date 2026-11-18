import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class DataSaver {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> records = new ArrayList<>();

        boolean moreData = true;

        while (moreData) {
            // Collect one person's record
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String id = SafeInput.getNonZeroLenString(in, "Enter ID");
            String title = SafeInput.getNonZeroLenString(in, "Enter Email");
            String yob = SafeInput.getRegExString(in, "Enter Year of Birth (YYYY)", "\\d{4}");

            String record = String.join(",", firstName, lastName, id, title, yob);
            records.add(record);

            moreData = SafeInput.getYNConfirm(in, "Do you want to enter another record?");
        }

        // Ask for file name to save to
        System.out.print("Enter file name to save (no spaces, no extension): ");
        String fileName = in.nextLine().trim();
        if (!fileName.endsWith(".csv")) {
            fileName += ".csv";
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("src/" + fileName))) {
            writer.println("First,Last,ID,Title,YOB");
            for (String r : records) {
                writer.println(r);
            }
            System.out.println("All records saved to " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
}