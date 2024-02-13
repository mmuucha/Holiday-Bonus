import static org.junit.Assert.*;
import org.junit.Test;
import java.io.File;
import java.io.FileNotFoundException;

public class TwoDimRaggedArrayUtilityTestStudent
{

    @Test
    public void testReadFile() 
    {
        try {
            File file = new File("testData.txt");
            double[][] result = TwoDimRaggedArrayUtility.readFile(file);

            // Add assertions based on the expected values from your test data
            assertEquals(3, result.length);
            assertEquals(2, result[0].length);
            assertEquals(3, result[1].length);
            assertEquals(4, result[2].length);
            assertEquals(1.5, result[0][0], 0.0001);  // Add more assertions as needed
            assertEquals(5.0, result[1][1], 0.0001);
            assertEquals(9.0, result[2][3], 0.0001);

        } catch (FileNotFoundException e) 
        {
            
        }
    }

    @Test
    public void testWriteToFile() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        try {
            File outputFile = new File("outputData.txt");
            TwoDimRaggedArrayUtility.writeToFile(data, outputFile);

            // Add assertions to check if the file is written correctly
            // You may read the file and compare the content if needed
            double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
            assertArrayEquals(data, result);

        } catch (FileNotFoundException e) 
        {
            fail("File not found exception: " + e.getMessage());
        }
    }

    @Test
    public void testGetTotal() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double total = TwoDimRaggedArrayUtility.getTotal(data);
        assertEquals(46.5, total, 0.0001);
    }

    @Test
    public void testGetAverage() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double average = TwoDimRaggedArrayUtility.getAverage(data);
        assertEquals(5.1667, average, 0.0001);
    }

    @Test
    public void testGetRowTotal()
    {
        double[][] data =
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double rowTotal = TwoDimRaggedArrayUtility.getRowTotal(data, 1);
        assertEquals(15.5, rowTotal, 0.0001);
    }

    @Test
    public void testGetColumnTotal() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double columnTotal = TwoDimRaggedArrayUtility.getColumnTotal(data, 1);
        assertEquals(15.0, columnTotal, 0.0001);
    }

    @Test
    public void testGetHighestInRow() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double highestInRow = TwoDimRaggedArrayUtility.getHighestInRow(data, 1);
        assertEquals(6.0, highestInRow, 0.0001);
    }

    @Test
    public void testGetHighestInRowIndex() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        int highestInRowIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 1);
        assertEquals(2, highestInRowIndex);
    }

    @Test
    public void testGetLowestInRow() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double lowestInRow = TwoDimRaggedArrayUtility.getLowestInRow(data, 1);
        assertEquals(4.5, lowestInRow, 0.0001);
    }

    @Test
    public void testGetLowestInRowIndex() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        int lowestInRowIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 1);
        assertEquals(0, lowestInRowIndex);
    }

    @Test
    public void testGetHighestInColumn()
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double highestInColumn = TwoDimRaggedArrayUtility.getHighestInColumn(data, 1);
        assertEquals(8.0, highestInColumn, 0.0001);
    }

    @Test
    public void testGetHighestInColumnIndex() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        int highestInColumnIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1);
        assertEquals(2, highestInColumnIndex);
    }

    @Test
    public void testGetLowestInColumn() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double lowestInColumn = TwoDimRaggedArrayUtility.getLowestInColumn(data, 1);
        assertEquals(2.0, lowestInColumn, 0.0001);
    }

    @Test
    public void testGetLowestInColumnIndex() 
    {
        double[][] data =
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        int lowestInColumnIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1);
        assertEquals(0, lowestInColumnIndex);
    }

    @Test
    public void testGetHighestInArray()
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double highestInArray = TwoDimRaggedArrayUtility.getHighestInArray(data);
        assertEquals(9.0, highestInArray, 0.0001);
    }

    @Test
    public void testGetLowestInArray() 
    {
        double[][] data = 
        	{
            {1.5, 2.0, 3.0},
            {4.5, 5.0, 6.0},
            {7.5, 8.0, 9.0}
        };

        double lowestInArray = TwoDimRaggedArrayUtility.getLowestInArray(data);
        assertEquals(1.5, lowestInArray, 0.0001);
    }

}
