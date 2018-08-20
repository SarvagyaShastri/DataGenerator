import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;


// Static iterator
// Throw output on standard out


class DataGeneratorUtil {
    private final int seed;
    Random r;
    static ArrayList<String> words;
    String[] stringArray;
    boolean debuggingEnabled;

    public DataGeneratorUtil(int seed, boolean debuggingEnabled) {
        this.seed = seed;
        this.r = new Random(seed);
        words = new ArrayList<>();
        this.debuggingEnabled = debuggingEnabled;
        readWords();
    }

    private void readWords() {
        File f = new File("/Users/sarvagyas/Documents/GeeksDP/src/words.txt");
        Scanner sc = null;
        try {
            sc = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please make sure words.txt is in the same path as the source file.");
            return;
        }
        sc.useDelimiter("\n");
        while (sc.hasNext()) {
            words.add(sc.next());
        }
    }


    public int randomInteger(int minValue, int maxValue) {
        int randomInteger = r.nextInt(maxValue - minValue + 1) + minValue;
        if (this.debuggingEnabled) {
            System.out.println("Random number generated: " + randomInteger);
        }
        return randomInteger;
    }

    public int[] generateIntegerArray(int size, int minValue, int maxValue) {
        int array[] = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(maxValue - minValue + 1) + minValue;
        }
        if (debuggingEnabled) {
            System.out.println("Integer array generated: " + Arrays.toString(array));
        }
        return array;
    }

    public int[] generateIntegerArrayWithUniqueElements(int size, int minValue, int maxValue) {
        HashSet<Integer> hashSet = new HashSet<>();
        int array[] = new int[size];
        while (hashSet.size() < size) {
            hashSet.add(r.nextInt(maxValue - minValue + 1) + minValue);
        }
        int index = 0;
        for (int i : hashSet
                ) {
            if (index < size) array[index++] = i;
        }
        if (debuggingEnabled) {
            System.out.println("Integer array generated: " + Arrays.toString(array));
        }
        return array;
    }


    public String[] generateWordArray(int arraySize) {
        stringArray = new String[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int randomIndex = r.nextInt(words.size() - i) + i;
            stringArray[i] = words.get(randomIndex);
        }
        if (debuggingEnabled) {
            System.out.println("String array generated: " + Arrays.toString(stringArray));
        }
        return stringArray;
    }

    public String generateWord() {
        String word = words.get(r.nextInt(words.size()));
        if (debuggingEnabled) {
            System.out.println("Word generated: " + word);
        }
        return word;
    }

    public String generateString(int maxWords) {
        String sentence = "";
        for (int i = 0; i < maxWords; i++) {
            sentence += words.get(r.nextInt(words.size())) + " ";
        }
        if (debuggingEnabled) {
            System.out.println(String.format("Sentence with %s words generated: %s", maxWords, sentence));
        }
        return sentence.trim();
    }


    public int[][] generateIntegerMatrix(int rows, int columns, int minValue, int maxValue) {
        int matrix[][] = new int[rows][columns];
        Random r = new Random(seed);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = r.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        if (debuggingEnabled) {
            printMatrix(matrix);
        }
        return matrix;
    }

    private void printMatrix(int[][] matrix) {
        for (int[] row: matrix
             ) {
            System.out.println(Arrays.toString(row));
        }
    }
}

/*public class DataGenerator {
    public static void main(String[] args) {
        DataGeneratorUtil dataGeneratorUtil = new DataGeneratorUtil(5);
        System.out.println(dataGeneratorUtil.generateString(4));
    }
}*/
