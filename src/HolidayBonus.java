public class HolidayBonus {

    // Constants for bonus amounts
    private static final double HIGHEST_SALES_BONUS = 5000.0;
    private static final double LOWEST_SALES_BONUS = 1000.0;
    private static final double OTHER_SALES_BONUS = 2000.0;

    // Private constructor to prevent instantiation
    private HolidayBonus() {
    }

  
    public static double[] calculateHolidayBonus(double[][] data) {
        int numRows = data.length;
        double[] bonuses = new double[numRows];

        for (int row = 0; row < numRows; row++) {
            double lowestSales = TwoDimRaggedArrayUtility.getLowestInRow(data, row);

            if (lowestSales > 0) {
                for (double sales : data[row]) {
                    if (sales == lowestSales) {
                        bonuses[row] += LOWEST_SALES_BONUS;
                    } else {
                        bonuses[row] += OTHER_SALES_BONUS;
                    }
                }
            } else {
                // All sales are non-positive, no bonus for this row
            }
        }

        return bonuses;
    }
    
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0.0;

        for (double[] row : data) {
            double highestSales = TwoDimRaggedArrayUtility.getHighestInArray(new double[][] { row });
            double lowestSales = TwoDimRaggedArrayUtility.getLowestInArray(new double[][] { row });

            if (highestSales > 0 && lowestSales > 0) {
                for (double sales : row) {
                    if (sales == highestSales) {
                        totalBonus += HIGHEST_SALES_BONUS;
                    } else if (sales == lowestSales) {
                        totalBonus += LOWEST_SALES_BONUS;
                    } else {
                        totalBonus += OTHER_SALES_BONUS;
                    }
                }
            } else if (highestSales > 0) {
                // Only one store with positive sales, eligible for the highest bonus
                totalBonus += HIGHEST_SALES_BONUS;
            }
            // If both highestSales and lowestSales are non-positive, no bonus for this row
        }

        return totalBonus;
    }
}