package com.example.admin.frist_week.bean;

public class MessageEvent {
    private String message;
    private String pic;

    public MessageEvent(String message, String pic) {
        this.message = message;
        this.pic = pic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPic() {

        return pic;
    }
}
