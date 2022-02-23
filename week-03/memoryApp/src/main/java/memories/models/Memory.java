package memories.models;

public class Memory {

    private int id;
    private String content;
    private String from;
    private boolean isShareable;

    public Memory(){

        // empty
    }

    public Memory(int id, String from, String content, boolean isShareable) {
        this.id = id;
        this.from = from;
        this.content = content;
        this.isShareable = isShareable;
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
