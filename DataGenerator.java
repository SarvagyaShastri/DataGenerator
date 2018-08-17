import java.util.Random;

class DataGeneratorUtil {
    private final int seed;

    public DataGeneratorUtil(int seed) {
        this.seed = seed;
    }

    public int[] generateIntegerArray(int size, int minValue, int maxValue) {
        int array[] = new int[size];
        Random r = new Random(seed);
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(maxValue - minValue + 1) + minValue;
        }
        return array;
    }

    public void generateIntegerArrayWithVariableRowSizes(int minRowLength, int maxRowLength, int minValue, int maxValue) {

    }

    public void generateStringArray(int size, int stringLength) {
        String strArray[] = new String[size];

    }

    public void generateSentences() {

    }

    public void generateStringArrayWithVariableLengthStrings(int minSize, int maxSize, int stringLength) {

    }

    public int[][] generateIntegerMatrix(int rows, int columns, int minValue, int maxValue) {
        int matrix[][] = new int[rows][columns];
        Random r = new Random(seed);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = r.nextInt(maxValue - minValue + 1) + minValue;
            }
        }
        return matrix;
    }
}

public class DataGenerator {
    public static void main(String[] args) {
        DataGeneratorUtil dataGeneratorUtil = new DataGeneratorUtil(5);
        int[] ints = dataGeneratorUtil.generateIntegerArray(10, 0, 10);
        for (int i: ints
             ) {
            System.out.println(i);
        }
    }
}
