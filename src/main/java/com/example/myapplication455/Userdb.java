package com.example.myapplication455;

public class Userdb {
    private long id;
    private String username;
    private String password;
    private String mail;
    private String phone;
    private int lngc;
    private int lngjava;
    private int lngphp;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String getMail(){
        return mail;
    }
    public void setMail(String mail){
        this.mail = mail;
    }
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    public int getlngC(){
        return lngc;
    }
    public void setlngC(int lngc){
        this.lngc=lngc;
    }
    public int getlngJava(){
        return lngjava;
    }
    public void setlngJava(int lngjava){
        this.lngjava=lngjava;
    }
    public int getlngPhp(){
        return lngphp;
    }
    public void setlngPhp(int lngphp){
        this.lngphp=lngphp;
    }

}
