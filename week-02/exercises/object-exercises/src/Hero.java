import java.util.Arrays;

public class Hero {


    private String name;
    private Power[] powers;


    public Hero(String name, Power[] powers){
        this.name = name;
        this.powers = powers;
    }

    public String getName() {
        return name;
    }

    public Power[] getPowers() {
        return powers;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setPowers(Power[] powers) {
        this.powers = powers;
    }

    public String toLine(){
        String ability = "";
        for(Power item : powers){
            item.getName();
            ability += item.getName() + ", ";
        }

        String sentence = getName() + " " + ability;
        //+ Arrays.toString(powers);
        return sentence;
    }
}
