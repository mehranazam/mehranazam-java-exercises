package learn;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Scanner;

@RestController
public class Controller {

   String[] choices = {"rock", "paper", "scissors"};


    @PostMapping("/api/guess")
    public String play(@PathVariable RPSThrow choice){
        for(String play : choices){
            if(play.equalsIgnoreCase(choice.getWhateverYouWant())){
                return playGame(choice.getWhateverYouWant());
            }
        }
        return "Not valid";
    }

    private String playGame(String choice){
        int comp = (int) (Math.random() * choices.length);
        String compChoice = choices[comp];
        if(choice.equalsIgnoreCase(compChoice)){
            return "It's a tie";
        }
        if(choice.equalsIgnoreCase("scissors") && compChoice.equalsIgnoreCase("paper")){
            return "Winner!!!";
        }
        if(choice.equalsIgnoreCase("paper") && compChoice.equalsIgnoreCase("rock")){
            return "Winner!!!";
        }
        if(choice.equalsIgnoreCase("rock") && compChoice.equalsIgnoreCase("scissors")){
            return "Winner!!!";
        }
        return "Loser!!";
    }

}
