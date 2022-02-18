import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class Exercise07Test {

    @Test
    void checkForReverseArray(){
        String[] checkReverse = {"a", "b", "c", "d", "e", "f"};

        String[] original = {"f", "e", "d", "c", "b", "a"};
        Exercise07 check = new Exercise07();
        assertEquals(checkReverse, check.reverseArray(original));
    }


}
