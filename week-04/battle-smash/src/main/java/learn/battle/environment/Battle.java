package learn.battle.environment;

import learn.battle.announcers.Announcer;
import learn.battle.announcers.Mumbler;
import learn.battle.fighters.Fighter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Battle {

    private final List<Location> locations;
    private Location battleLocation;
    private final List<Fighter> fighters;
    private Weather weather;
    private final Random random = new Random();

    private ArrayList<Fighter> current = new ArrayList<>();
    private Announcer announcer = new Mumbler();
    private int round = 0;
    private boolean isOver = false;

    public Battle(List<Location> locations, List<Fighter> fighters) {
        this.locations = locations;
        this.fighters = fighters;
    }

    public void setAnnouncer(Announcer announcer) {
        this.announcer = announcer;
    }

    public void run() {

        if (!setUp()) {
            return;
        }

        welcome();

        while (!isOver) {
            sleep(2500);
            round++;
            announceRound();
            executeRound();
        }

        announceWin();
    }

    private boolean setUp() {

        if (locations == null) {
            announcer.announce("A battle requires a location.");
            return false;
        }

        int randStage = random.nextInt(this.locations.size());

        this.battleLocation = this.locations.get(randStage);

        int randWeather = random.nextInt(Weather.values().length);
//        System.out.println(randWeather);
        weather = Weather.weatherNumToType(randWeather);
        System.out.println(this.weather.getWeatherType());
        if (fighters == null || fighters.size() < 2 || fighters.size() > 8) {
            announcer.announce("A battle requires between 2 and 8 fighters.");
            return false;
        }

        current.addAll(fighters);

        return true;
    }

    private void welcome() {

        announcer.announce("Good afternoon battle enthusiasts!");
        announcer.announce("Today's battle takes place in: " + battleLocation.getName());
        announcer.announce("And the weather is " + weather.getWeatherType());
        announcer.announce("");

        announcer.announce("Our fighters include:");
        for (Fighter fighter : current) {
            announcer.announce(fighter.getName());
        }

        sleep(1500);
        announcer.announce("");
        announcer.announce("AAAAAAND WE'RE READY TO BATTLE!");
        sleep(1000);
        announcer.announce("................");
        announcer.announce("GO!");
    }

    private void announceRound() {
        announcer.announce("");
        String msg = "At the beginning of Round #" + round;
        announcer.announce(msg);
        announcer.announce("=".repeat(msg.length()));
        for (Fighter fighter : current) {
            msg = String.format("%s's balance is %s.", fighter.getName(), fighter.getBalance());
            announcer.announce(msg);
        }
        announcer.announce("");
        sleep(1000);
    }

    private void executeRound() {

        List<Fighter> orderedFighters = current.stream()
                .sorted((a, b) -> random.nextInt())
                .collect(Collectors.toList());



        for (Fighter attacker : orderedFighters) {

            // eliminated earlier in the round
            if (attacker.isOut()) {
                continue;
            }

            Fighter attacked = null;
            do {
                attacked = current.get(random.nextInt(current.size()));
            } while (attacker == attacked);

            boolean isSpecialAttack = false;
            int specialNum = random.nextInt(100) + 1;
            if(specialNum <= 20){
                isSpecialAttack = true;
            }

            int balanceDrain = random.nextInt(20) + 5;
            if(isSpecialAttack){
                balanceDrain *= 2;
                attacked.reduceBalance(balanceDrain);
                announcer.announce(String.format(
                        "%s uses %s on %s and drains %s (2x normal) balance.",
                        attacker.getName(),
                        attacker.getSpecialAttack(),
                        attacked.getName(),
                        balanceDrain
                ));
            }else {
                attacked.reduceBalance(balanceDrain);
                announcer.announce(String.format(
                        "%s attacks %s and drains %s balance.",
                        attacker.getName(),
                        attacked.getName(),
                        balanceDrain
                ));
            }
            if (attacked.isOut()) {
                announcer.announce("... and knocks them out of the battle!");
                current.remove(attacked);
            }

            sleep(350);
        }

        isOver = current.size() == 1;
    }

    private void announceWin() {
        announcer.announce("");
        String msg = String.format(
                "%s WINS at %s in %s weather in %s rounds!",
                current.get(0).getName(),
                battleLocation.getName(),
                weather.getWeatherType(),
                round);
        announcer.announce(msg);
        announcer.announce("=".repeat(msg.length()));
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
