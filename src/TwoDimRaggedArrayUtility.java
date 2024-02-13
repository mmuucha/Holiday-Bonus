import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility {

    private TwoDimRaggedArrayUtility() {
        // private constructor to prevent instantiation
    }

    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int rows = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            rows++;
        }
        scanner.close();

        double[][] array = new double[rows][];
        scanner = new Scanner(file);
        for (int i = 0; i < rows; i++) {
            String[] values = scanner.nextLine().split(" ");
            array[i] = new double[values.length];
            for (int j = 0; j < values.length; j++) {
                array[i][j] = Double.parseDouble(values[j]);
            }
        }
        scanner.close();

        return array;
    }

    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(outputFile);
        for (double[] row : data) {
            for (double value : row) {
                writer.print(value + " ");
            }
            writer.println();
        }
        writer.close();
    }

    public static double getTotal(double[][] data) {
        double total = 0;
        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }
        return total;
    }

    public static double getAverage(double[][] data) {
        return getTotal(data) / getNumOfElements(data);
    }

    public static double getRowTotal(double[][] data, int row) {
        double total = 0;
        if (isValidRow(data, row)) {
            for (double value : data[row]) {
                total += value;
            }
        }
        return total;
    }

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;
        for (double[] row : data) {
            if (isValidColumn(row, col)) {
                total += row[col];
            }
        }
        return total;
    }

    public static double getHighestInRow(double[][] data, int row) {
        double highest = Double.MIN_VALUE;
        if (isValidRow(data, row)) {
            for (double value : data[row]) {
                highest = Math.max(highest, value);
            }
        }
        return highest;
    }
    public static int getHighestInRowIndex(double[][] data, int row) {
        int index = -1;
        if (isValidRow(data, row)) {
            double highest = Double.MIN_VALUE;
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] > highest) {
                    highest = data[row][i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static double getLowestInRow(double[][] data, int row) {
        double lowest = Double.MAX_VALUE;
        if (isValidRow(data, row)) {
            for (double value : data[row]) {
                lowest = Math.min(lowest, value);
            }
        }
        return lowest;
    }

    public static int getLowestInRowIndex(double[][] data, int row) {
        int index = -1;
        if (isValidRow(data, row)) {
            double lowest = Double.MAX_VALUE;
            for (int i = 0; i < data[row].length; i++) {
                if (data[row][i] < lowest) {
                    lowest = data[row][i];
                    index = i;
                }
            }
        }
        return index;
    }

    public static double getHighestInColumn(double[][] data, int col) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            if (isValidColumn(row, col)) {
                highest = Math.max(highest, row[col]);
            }
        }
        return highest;
    }

    public static int getHighestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double highest = Double.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (isValidColumn(data[i], col) && data[i][col] > highest) {
                highest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static double getLowestInColumn(double[][] data, int col) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            if (isValidColumn(row, col)) {
                lowest = Math.min(lowest, row[col]);
            }
        }
        return lowest;
    }

    public static int getLowestInColumnIndex(double[][] data, int col) {
        int index = -1;
        double lowest = Double.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (isValidColumn(data[i], col) && data[i][col] < lowest) {
                lowest = data[i][col];
                index = i;
            }
        }
        return index;
    }

    public static double getHighestInArray(double[][] data) {
        double highest = Double.MIN_VALUE;
        for (double[] row : data) {
            for (double value : row) {
                highest = Math.max(highest, value);
            }
        }
        return highest;
    }

    public static double getLowestInArray(double[][] data) {
        double lowest = Double.MAX_VALUE;
        for (double[] row : data) {
            for (double value : row) {
                lowest = Math.min(lowest, value);
            }
        }
        return lowest;
    }

    private static int getNumOfElements(double[][] data) {
        int count = 0;
        for (double[] row : data) {
            count += row.length;
        }
        return count;
    }

    private static boolean isValidRow(double[][] data, int row) {
        return row >= 0 && row < data.length;
    }

    private static boolean isValidColumn(double[] row, int col) {
        return col >= 0 && col < row.length;
    }
}