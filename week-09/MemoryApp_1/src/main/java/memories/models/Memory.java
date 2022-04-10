package memories.models;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class Memory {


    private int id;

    @NotBlank(message = "Sender required.")
    @NotNull(message = "Sender required.")
    private String from;

    @NotBlank(message = "Content required.")
    @NotNull(message = "Content required.")
    private String content;

//    @NotBlank(message = "Sharing status required.")
//    @NotNull(message = "Sharing status required.")
    private boolean isShareable;

    public Memory(int id, boolean isSharable) {
        this.id = id;
        this.isShareable = isSharable;
    }

    public Memory() {
        // empty constructor
    }
    public Memory(int id, String from, String content, boolean isSharable) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.isShareable = isSharable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isShareable() {
        return isShareable;
    }

    public void setShareable(boolean shareable) {
        isShareable = shareable;
    }




}
