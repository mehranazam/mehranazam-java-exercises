package learn.solar.domain;

import learn.solar.models.Panel;

import java.util.ArrayList;

public class PanelResult {

    private ArrayList<String> messages = new ArrayList<>();
    private Panel payload;
    private Panel panel;

    public void addErrorMessage(String message){
        messages.add(message);
    }

    public boolean isSuccess(){
        return messages.size() == 0;
    }

    public ArrayList<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void setPayload(Panel payload) {
        this.payload = payload;
    }

    public Panel getPayload() {
        return payload;
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }
}
