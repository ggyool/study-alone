package a511_scanner_example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = null;
        while (true) {
            String prompt = ">>";
            System.out.print(prompt);

            String input = scanner.nextLine();
            input = input.trim();
            arr = input.split(" +");
            String command = arr[0];
            if ("".equals(command)) {
                continue;
            }
            command = command.toLowerCase();

            if (command.equals("q")) {
                System.exit(0);
            } else {
                for (int i = 0; i < arr.length; i++) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
