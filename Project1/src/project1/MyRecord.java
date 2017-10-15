/*
* Programmar:  Brian Barr 
* Project 1 
* File: MyRecord.java 
* date: 5 october 2017
* professor: Chris Ferguson  
* Program Description: MyRecord.java contains the code for the  MyRecord class: 
* standard get and set methods, and a toString method  
*/

package project1; 

public class MyRecord {
	private String firstname, lastname, email, color, record_string;
	private int id; 
        private float balance;  
   

        
    public MyRecord (){ 	//default constructor 
        this.firstname = " ";
        this.lastname = ""; 
        this.email = ""; 
        this.id = 0; 
        this.color = ""; 
        this.balance = (float) 0.0 ; 
    } 

    public MyRecord(String firstname, String lastname, String email, int id, String color, float balance){ 
    	setFirstname(firstname); 
    	setLastname(lastname); 
    	setEmail(email); 
    	setId(id);
    	setColor(color); 
    	setBalance(balance); 

    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    
    @Override
    public String toString() {
        return "MyRecord{" + "firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + ", color=" + color + ", record_string=" + record_string + ", id=" + id + ", balance=" + balance + '}';
    }

}// end class 

