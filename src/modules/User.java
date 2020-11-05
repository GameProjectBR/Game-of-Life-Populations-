package Modules;

public class User {
    protected String USERNAME;
    protected String PASSWORD;
    
    public User(){ 
    }
    
    public User(String u, String p){
        this.USERNAME = u;
        this.PASSWORD = p;
    }
    public String getUsername(){
        return USERNAME;
    }
    public void setUsername(String u){
        this.USERNAME = u;
    }
    public String getPassword(){
        return PASSWORD;
    }
    public void setPassword(String p){
        this.PASSWORD = p;
    }
    
}
