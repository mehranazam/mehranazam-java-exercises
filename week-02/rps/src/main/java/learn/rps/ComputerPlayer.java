package learn.rps;

import java.util.Random;

public class ComputerPlayer implements GamePlayer{

    private Random random = new Random();

    @Override
    public int move() {
        return random.nextInt(3) + 1;
    }
}
