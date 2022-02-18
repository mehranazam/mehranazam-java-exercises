package learn.rps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class GameTest {

    // rock should beat scissors

    // scissors should beat paper

    // paper should beat rock

    AlwaysRock player1 = new AlwaysRock();
    AlwaysScissors player2 = new AlwaysScissors();



    @BeforeEach
    void welcome(){
        System.out.println("Welcome to our testing world!");
    }



    @Test
    void paperShouldBeatRock()
    {

        Game game = new Game(player1, player2);
        int result = game.playGame();
        assertEquals(result, -1);

    }


    @Test
    void shouldTie(){

    }

    @Test
    void rockShouldBeatScissors(){

    }

}
