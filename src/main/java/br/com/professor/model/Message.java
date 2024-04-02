package br.com.professor.model;

public class Message {
    
    private String title;
    private String defaultText;

    public Message(String text) {
        this.title = text;
        this.defaultText = "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String text) {
        this.title = text;
    }

    public String getDefaultText() {
        return defaultText;
    }

    public void setDefaultText(String defaultText) {
        this.defaultText = defaultText;
    }
    
}
