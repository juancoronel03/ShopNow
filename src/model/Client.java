package model; 

public class Client{
    private String name; 
    private String email;
    
    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    
    public void showInfo() {
        System.err.println("Name: "+name+"\nEmail: "+email);
    } 

    

}