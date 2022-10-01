package com.example.fdm.NGO;

public class NGO {
    public String email, password;

    public NGO(){

    }

    public NGO(String email, String password){
        this.email = email;
        this.password=password;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password=password;
    }
}
