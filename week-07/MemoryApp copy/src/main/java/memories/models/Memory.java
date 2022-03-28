package memories.models;

public class Memory {

    private int id;
    private String from;
    private String content;
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
