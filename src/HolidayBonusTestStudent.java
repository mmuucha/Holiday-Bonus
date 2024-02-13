import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HolidayBonusTestStudent {

    @Test
    public void testCalculateHolidayBonus() {
        double[][] data = {
            { 1000, 2000, 3000 },
            { 0, 0 },
            { -500, -1000, -2000 },
            { 5000, 5000, 5000 },
            { 2000, 3000 }
        };

        double[] expectedBonuses = { 3000.0, 0.0, 0.0, 15000.0, 4000.0 };

        double[] actualBonuses = HolidayBonus.calculateHolidayBonus(data);

        for (int i = 0; i < expectedBonuses.length; i++) {
            assertEquals(expectedBonuses[i], actualBonuses[i], 0.001);
        }
    }

    @Test
    public void testCalculateTotalHolidayBonus() {
        double[][] data = {
            { 1000, 2000, 3000 },
            { 0, 0 },
            { -500, -1000, -2000 },
            { 5000, 5000, 5000 },
            { 2000, 3000 }
        };

        double expectedTotalBonus = 39000.0;

        double actualTotalBonus = HolidayBonus.calculateTotalHolidayBonus(data);

        assertEquals(expectedTotalBonus, actualTotalBonus, 0.001);
    }
}