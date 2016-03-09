import java.util.*;
/**
 * File creates a file that stores a patient id
 * @author Charbel
 */
public class createFile {
    private Formatter x;
    /**
     * creates a file called patientid.txt
     */
    public void openFile(){
        try{
           x = new Formatter("patientid.txt");
        }
        catch(Exception e){
               System.out.println("error");
        }
    }
    /**
     * Takes in a patient ID string and then stores that with in file. Allows for patient id to continue to rise, in spite of ending the program.
     * @param patientid of type string
     */
    public void changeText(String patientid){
        patientID = patientid;
        x.format("%s", patientID );
    }
    /**
     * Closes the file.
     */
    public void closeFile(){
        x.close();
    }
    public String patientID;
}