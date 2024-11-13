import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int N = 4;
        double[][] matrix = new double[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Math.random() * 100; // випадкові числа від 0 до 100
            }
        }

        System.out.println("Початкова матриця:");
        printMatrix(matrix);

        int rowIndex = 1;

        sortMatrixByRow(matrix, rowIndex);

        System.out.println("Відсортована матриця:");
        printMatrix(matrix);
    }

    public static void printMatrix(double[][] matrix) {
        for (double[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static void sortMatrixByRow(double[][] matrix, int rowIndex) {
        double[] rowToSort = matrix[rowIndex];

        Integer[] columnIndices = new Integer[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            columnIndices[i] = i;
        }

        Arrays.sort(columnIndices, (a, b) -> Double.compare(rowToSort[a], rowToSort[b]));


        double[][] sortedMatrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                sortedMatrix[i][j] = matrix[i][columnIndices[j]];
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = sortedMatrix[i];
        }
    }
}
