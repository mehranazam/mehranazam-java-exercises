import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Exercise05Test {


    @Test
    void isWithinFiveOfOneHundred(){
        assertEquals(true, Exercise05.isWithinFiveOfAHundred(100));
        assertEquals(true, Exercise05.isWithinFiveOfAHundred(50));
        assertEquals(false, Exercise05.isWithinFiveOfAHundred(94));

    }
}
