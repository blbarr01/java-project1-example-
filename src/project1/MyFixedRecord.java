/*
* Programmar:  Brian Barr 
* Project 1
* file: MyFixedRecord.java 
* date: 5 october 2017
* professor: Chris Ferguson  
* Program Description: MyFixedRecord.java contains the code for the MyFixedRecord class: 
* standard get methods. set methods read in a char array and then fill in the absent indexes with 
* spaces before assigning the data to the object. This was done to minimize changes to the code 
* in the event modifications are wished. in theory one only needs to change the *ArraySize Variables
* 
*/

package project1;

public class MyFixedRecord{

// variable initialization 
	protected final int FirstNameArraySize = 10; 
	protected final int LastNameArraySize = 15 ; 
	protected final int EmailArraySize = 25 ; 
	protected final int IdArraySize = 10 ; 	
	protected final int ColorArraySize = 10 ; 	
	protected final int BalanceArraySize = 10 ; 	

	private char[] firstname = new char[FirstNameArraySize];
	private char[] lastname = new char[LastNameArraySize]; // create variables for the arraysizes 
	private char[] email = new char[EmailArraySize];  
	private char[] id = new char[IdArraySize];
	private char[] color = new char[ColorArraySize];
	private char[] balance = new char[BalanceArraySize];

    public MyFixedRecord() {
    
    }
    
        // get methods 
    public char[] getFirstname() {
        return firstname;
    }

    public char[] getLastname() {
        return lastname;
    }

    public char[] getEmail() {
        return email;
    }

    public char[] getId() {
        return id;
    }
    public char[] getColor() {
        return color;
    }

    public char[] getBalance() {
        return balance;
    }
    
    // set methods 
    public void setFirstname(char[] firstname) {
       char [] tempCharArray= new char[FirstNameArraySize];
       for (int i = 0; i < FirstNameArraySize ; i ++){
           if (i < firstname.length)
           tempCharArray[i] = firstname[i];
           else tempCharArray[i] = ' '; 
           
       }
           this.firstname = tempCharArray;  
    }

    public void setLastname(char[] lastname) {
       char [] tempCharArray= new char[LastNameArraySize];
       for (int i = 0; i < LastNameArraySize ; i ++){
           if (i < lastname.length)
           tempCharArray[i] = lastname[i];
           else tempCharArray[i] = ' '; 
    	}
           this.lastname = tempCharArray;
}

    public void setEmail(char[] email) {
        char [] tempCharArray = new char[EmailArraySize]; 
        for (int i = 0; i < EmailArraySize  ; i++){
        	if (i < email.length) 
        		tempCharArray[i] = email[i]; 
        	else tempCharArray[i] = ' '; 
        } 
        	this.email = tempCharArray; 
    }


    public void setId(char[] id) {
        char [] tempCharArray = new char[IdArraySize]; 
        for (int i = 0; i < IdArraySize  ; i++){
        	if (i < id.length) 
        		tempCharArray[i] = id[i]; 
        	else tempCharArray[i] = ' '; 
        } 
        	this.id = tempCharArray;
        }

    public void setColor(char[] color) {
        char [] tempCharArray = new char[ColorArraySize]; 
        for (int i = 0; i < ColorArraySize ; i++){
        	if (i < color.length) 
        		tempCharArray[i] = color[i]; 
        	else tempCharArray[i] = ' '; 
        } 
        	this.color = tempCharArray;
    }


    public void setBalance(char[] balance) {
       char[] tempCharArray = new char[BalanceArraySize]; 
       for (int i = 0; i< BalanceArraySize; i++){
       	if (i < balance.length)
       		tempCharArray[i] = balance[i]; 
       	else 
       		tempCharArray[i] = ' '; 
       }
       this.balance = tempCharArray; 
    }
        
        

	
}// end class 