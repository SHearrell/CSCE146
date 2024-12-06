import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordSorterApp {

    public static final String FILE_NAME = "resources/randomWords.txt";

    public static void main(String[] args) {
        // Reads the given text file
        String[] words = readFile(FILE_NAME);

        // Check for null before proceeding
        if (words == null) {
            System.out.println("Error reading words from the file.");
            return;
        }

        // Sorts the words using various criteria
        String[] vowelSorted = WordHelper.sortByVowels(words);
        String[] conSorted = WordHelper.sortByConsonants(words);
        String[] lenSorted = WordHelper.sortByLength(words);

        // Print the results
        System.out.println("The original word list");
        printStrArr(words);
        System.out.println("\nThe word list sorted by Vowels");
        printStrArr(vowelSorted);
        System.out.println("\nThe word list sorted by Consonants");
        printStrArr(conSorted);
        System.out.println("\nThe word list sorted by Length");
        printStrArr(lenSorted);
    }

    public static String[] readFile(String fileName) {
        try {
            InputStream inputStream = WordSorterApp.class.getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                System.out.println("File not found: " + fileName);
                return new String[0];
            }
            Scanner fileScanner = new Scanner(inputStream);
            List<String> wordsList = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                wordsList.add(fileScanner.nextLine());
            }
            return wordsList.toArray(new String[0]);
        } catch (Exception e) {
            System.out.println("Error reading the file: " + e.getMessage());
            return new String[0];
        }
    }

    public static void printStrArr(String[] words) {
        for (String s : words)
            System.out.println(s);
    }
}
