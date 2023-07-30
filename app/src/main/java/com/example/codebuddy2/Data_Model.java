package com.example.codebuddy2;

public class Data_Model {

    private String name,phone,mail,git,link;


    public  Data_Model(){}

    public Data_Model(String name, String phone, String mail, String git, String link) {
        this.name = name;
        this.phone = phone;
        this.mail = mail;
        this.git = git;
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getGit() {
        return git;
    }

    public void setGit(String git) {
        this.git = git;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
