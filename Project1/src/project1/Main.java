/*
* programmar:  Brian Barr 
* Project 1 
* File: Main.java 
* date: 5 october 2017
* professor: Chris Ferguson  
* Program Description: this project focuses on the reading and writing of files and the creation
* of objects from that data. 
*   From the Main file, the user has a prompt from which he can display a record's content
* in addition to the record's appropriate hash value. furthermore, the user can convert 
* the MyRecord Objects to FixedRecord Objects and then print the FixedRecord objects to a file.    
 */
package project1;

import java.io.*;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Brian 
 */
public class Main {

    protected static final int ARRAYSIZE = 10;
    protected static MyRecord[] recordArray = new MyRecord[ARRAYSIZE]; //decleration of Myrecord objs array 
    protected static MyFixedRecord[] fixedRecords = new MyFixedRecord[ARRAYSIZE];
    protected static int totalRecords = 0;
    protected static final int HASHSIZE = 1001;
    protected static int record_size = 80; 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int selection = 0;
        readProgram();  // method call to read the file; this is done by default b/c without records nothing would work 
        do {
            mainMenuPrompt();
            Scanner selector = new Scanner(System.in);
            selection = selector.nextInt();
            switch (selection) {
                case 1: {
                    displayRecordsPrompt(); 
                    break;
                } // end case 1
                case 2: {
                    makeFixedRecords();
                    myFixedRecordPrompt(); 
                    break;
                }
                default: {
                    if (selection == -1) {
                        System.out.println("goodbye");
                    } else {
                        System.out.println("non-valid input");
                   
                    }
                    break;
                }
            }// end switch

        } while (selection >= 0);
    }// end main


    public static void readProgram() { // should i keep this static? 

        int array_index = 0;
        try {
            String fileName = "Data.txt", line, record_string;
            // File fileObj = new File(fileName);
            Path pathObj = Paths.get(fileName);
            Scanner input = new Scanner(pathObj);
            while (input.hasNextLine()) { // loop through to read each line of the file
                // console output for testing
                line = input.nextLine();
                //System.out.println(line);
                String dataStrings[] = line.split(", ");

                /* // testing info loop: 
                for(String temp: dataStrings)
                 System.out.println(temp);
                 */
                String tempFirstname = dataStrings[0];
                String tempLastName = dataStrings[1];
                String tempEmail = dataStrings[2];
                int tempId = Integer.valueOf(dataStrings[3]);
                String tempColor = dataStrings[4];
                float tempBalance = Float.valueOf(dataStrings[5]);

                MyRecord tempRecord = new MyRecord(tempFirstname, tempLastName, tempEmail, tempId, tempColor, tempBalance);
                recordArray[array_index] = tempRecord;
                array_index++;
                totalRecords++;

            }
            input.close(); // close the read file 
        } //end try block
        catch (Exception e) {
            System.out.println("Error:" + e);
            

        } // end catch 
    } //end readProgram Function; 

    public static void writeProgram() {
        try {
            String filename = "testData.txt";
            File fileObj = new File(filename);
            PrintWriter output = new PrintWriter(fileObj);
            int sum = 0, index = 0;
            while (fixedRecords[index] != null) {
                output.print(fixedRecords[index].getLastname());
                output.print(fixedRecords[index].getFirstname());
                output.print(fixedRecords[index].getEmail());
                output.print(fixedRecords[index].getId());
                output.print(fixedRecords[index].getColor());
                output.print(fixedRecords[index].getBalance());
               /*
                int difference = record_size - sum;
                char [] filler = new char[difference]; 
                for(char i: filler)
                    filler[i] = ' '; 
                for(char i: filler)
                    output.print(filler[i]);
                */
                output.print("\n");
                index++;
            }
            output.close();
            System.out.println("successful print! check the file.");
        } catch (Exception e) {
            System.out.println("error:" + e);
            e.printStackTrace();
        }

    }

    static void  displayRecordsPrompt(){ 
        int record_selection; 
                  do {
                       
                        // record display loop 
                        System.out.println("please insert a record number between 1 and " + totalRecords + " or press -1 to exit: ");
                        Scanner scan = new Scanner(System.in);
                      record_selection = scan.nextInt();

                        if (record_selection > 0 && record_selection <= totalRecords) {
                            System.out.println(recordArray[record_selection - 1].toString() + "\n"); // needs to be subtracted by 1 to display proper value
                            int bucketNumber = hashFunc3(recordArray[record_selection - 1].getEmail());  // hash function call 
                            System.out.println("key " + recordArray[record_selection - 1].getEmail() + " shoud be stored at " // data display 
                                    + bucketNumber);
                            System.out.println("------------------------------------------ \n");
                        } else if (record_selection == -1) {
                            System.out.println("goodbye");
                        } else {
                            System.out.println("this is not a valid input. ");
                        }
                    } while (record_selection > 0);
    }

    static void myFixedRecordPrompt() {
      
        do {
            System.out.println("please inert a record size between 80 - 128: ");
            System.out.println("Warning: if inapropriate value is input, a default record size of 80 will be used. ");
            System.out.println("insert -1 to exit.");
            Scanner scan = new Scanner(System.in);
            int temp = scan.nextInt();
            if (temp >= 80 && temp <= 128) {
                record_size = temp;
            writeProgram();     
            } else if (temp == -1) {
                break;
            }
        } while (record_size > 80);

    } // end fixed record prompt 

    static void mainMenuPrompt() {
        System.out.println("/n");
        System.out.println("please make a selection");
        System.out.println("-------------------------");
        System.out.println("1: read record / display records");
        System.out.println("2: write records in a different format");
        System.out.println("-1: exit program");
    }

    static void makeFixedRecords() {
        int index = 0;
        while (recordArray[index] != null){  // while there's something in the array 
            MyFixedRecord tempRecord = new MyFixedRecord(); // create a temporary MyFixedRecord obj
            fixedRecords[index] = tempRecord;              // assign that obj to the index of the FixedRecord array
            // copy data fields from the MyRecord obj to the corresponding FixedRecord object's data fields 
            fixedRecords[index].setFirstname(recordArray[index].getFirstname().toCharArray()); 
            fixedRecords[index].setLastname(recordArray[index].getLastname().toCharArray());
            fixedRecords[index].setEmail(recordArray[index].getEmail().toCharArray());
            fixedRecords[index].setId(String.valueOf(recordArray[index].getId()).toCharArray());
            fixedRecords[index].setColor(recordArray[index].getColor().toCharArray());
            fixedRecords[index].setBalance(String.valueOf(recordArray[index].getBalance()).toCharArray());
            index++;

        }
    } // end make fixed records 

    // EVERYONE, PLEASE USE THE SAME HASH FUNCTION, DO NOT CHANGE
    public static int hashFunc3(String key) {
        int hashval = 0;
        for (int j = 0; j < key.length(); j++) {
            int letter = key.charAt(j) - 96;
            if (letter > 0) {
                hashval = (hashval * 27 + letter) % HASHSIZE;
            }
        }
        return hashval;
    }

} // end Main Class
