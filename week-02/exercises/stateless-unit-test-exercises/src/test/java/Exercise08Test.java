import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exercise08Test {
    String[] week = {"Mon", "Tues", "Weds", "Thurs", "Fri", "Sat", "Sun"};
    StringMethods check = new StringMethods();

    @Test
    void checkForDaysOfWeek(){
        assertEquals(true, check.startsWithDayOfWeek(week));
    }
}
