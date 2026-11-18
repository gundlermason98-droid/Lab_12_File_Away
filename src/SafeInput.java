import java.util.Scanner;

public class SafeInput {

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String response = "";
        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine().trim();
        } while (response.length() == 0);
        return response;
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String response = "";
        boolean done = false;

        do {
            System.out.print(prompt + ": ");
            response = pipe.nextLine();
            if (response.matches(regEx)) {
                done = true;
            } else {
                System.out.println("Invalid input: " + response);
            }
        } while (!done);

        return response;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response = "";
        boolean result = false;
        boolean done = false;

        do {
            System.out.print(prompt + " [Y/N]: ");
            response = pipe.nextLine().trim();
            if (response.equalsIgnoreCase("Y")) {
                result = true;
                done = true;
            } else if (response.equalsIgnoreCase("N")) {
                result = false;
                done = true;
            } else {
                System.out.println("Please enter Y or N.");
            }
        } while (!done);

        return result;
    }
}