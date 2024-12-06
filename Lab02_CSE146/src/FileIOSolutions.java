//Simeon Hearrell
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileIOSolutions {

    private static String readFilePath;
    private static String outputFilePath;
    private static String tubeFilePath;

    // Setter method for file paths
    public static void setFilePaths(String read, String output, String tube) {
        readFilePath = read;
        outputFilePath = output;
        tubeFilePath = tube;
    }

    public static void pastTense(String read, String output) {
        setFilePaths(read, output, "");
        pastTense();
    }

    public static void pastTense() {
        try (Scanner scanner = new Scanner(new File(readFilePath));
             PrintWriter writer = new PrintWriter(outputFilePath)) {

            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase(); // convert to lowercase

                if (word.equals("is")) {
                    word = "was";
                }

                System.out.println(word);
                writer.println(word);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static double totalTubeVolume(String tube) {
        setFilePaths("", "", tube);
        return totalTubeVolume();
    }

    public static double totalTubeVolume() {
        double totalVolume = 0.0;

        try (Scanner scanner = new Scanner(new File(tubeFilePath))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("\t");

                if (parts.length == 3) {
                    try {
                        double radius = Double.parseDouble(parts[1]);
                        double height = Double.parseDouble(parts[2]);

                        double volume = Math.PI * Math.pow(radius, 2) * height;
                        totalVolume += volume;

                    } catch (NumberFormatException e) {
                        // Ignore lines with invalid format
                        continue;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return totalVolume;
    }
}

