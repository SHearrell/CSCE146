import java.util.Comparator;

public class WordHelper {

    public static String[] sortByVowels(String[] words) {
        String[] sortedWords = copyArray(words);
        customSort(sortedWords, Comparator.comparingInt(WordHelper::countVowels));
        return sortedWords;
    }

    public static String[] sortByConsonants(String[] words) {
        String[] sortedWords = copyArray(words);
        customSort(sortedWords, Comparator.comparingInt(WordHelper::countConsonants));
        return sortedWords;
    }

    public static String[] sortByLength(String[] words) {
        String[] sortedWords = copyArray(words);
        customSort(sortedWords, Comparator.comparingInt(String::length));
        return sortedWords;
    }

    private static String[] copyArray(String[] words) {
        String[] copiedArray = new String[words.length];
        System.arraycopy(words, 0, copiedArray, 0, words.length);
        return copiedArray;
    }

    private static void customSort(String[] array, Comparator<String> comparator) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (comparator.compare(array[j], array[j + 1]) > 0) {
                    // Swap the elements if they are in the wrong order
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    private static int countVowels(String word) {
        return (int) word.toLowerCase().chars().filter(c -> "aeiou".indexOf(c) != -1).count();
    }

    private static int countConsonants(String word) {
        return (int) word.toLowerCase().chars().filter(c -> "bcdfghjklmnpqrstvwxyz".indexOf(c) != -1).count();
    }
}
