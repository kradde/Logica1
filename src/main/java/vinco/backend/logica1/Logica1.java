package vinco.backend.logica1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Alex Garcia
 */
public class Logica1 {

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader("input.txt"));
            String line = reader.readLine();
            // ignore the first line, get the second line
            line = reader.readLine();
            while (line != null) {
                String[] split = line.trim().split(" ");
                int ingredients = Integer.parseInt(split[0]);

                int max = Integer.parseInt(split[1]);
                for (int i = 2; i < ingredients; i++) {
                    max = mcd(max, Integer.parseInt(split[i]));
                }

                for (int i = 0; i < ingredients; i++) {
                    System.out.print(Integer.parseInt(split[i + 1]) / max);
                }
                System.out.println();
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo: " + e.getMessage());
                }
            }
        }
    }

    public static int mcd(int num1, int num2) {
        if (num2 == 0) {
            return num1;
        }
        return mcd(num2, num1 % num2);
    }
}
