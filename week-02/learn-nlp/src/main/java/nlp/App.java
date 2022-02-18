package nlp;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.Token;

public class App {
    public static void main(String[] args) {
        String text = "Liverpool won yesterday";

        Document doc = new Document(text);
        for (Sentence sentence : doc.sentences()) {
            for(Token token : sentence.tokens()){
                System.out.printf("%-10s: %-3s: %s%n", token.word(), token.posTag(), token.nerTag());
            }
        }
    }
}
