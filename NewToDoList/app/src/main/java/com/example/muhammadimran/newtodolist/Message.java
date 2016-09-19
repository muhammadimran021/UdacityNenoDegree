package com.example.muhammadimran.newtodolist;

/**
 * Created by Muhammad imran on 4/5/2016.
 */
public class Message {
    private int Id;
    private String Title;
    private String Mail;
    boolean read;

    public Message(int id, String title, String mail, boolean read) {
        Id = id;
        Title = title;
        Mail = mail;
        this.read = read;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getMail() {
        return Mail;
    }

    public void setMail(String mail) {
        Mail = mail;
    }

    public boolean isRead() {
        return read;
    }

    public void setRead(boolean read) {
        this.read = read;
    }
}
