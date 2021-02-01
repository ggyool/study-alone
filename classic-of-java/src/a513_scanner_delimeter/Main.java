package a513_scanner_delimeter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("./src/a513_scanner_delimeter/dummy.txt"));
        int cnt = 0;
        int sum = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner numScanner = new Scanner(line).useDelimiter(" +");
            while (numScanner.hasNextInt()) {
                sum += numScanner.nextInt();
                cnt++;
            }
        }
        System.out.println(sum);
        System.out.println(cnt);
    }
}
