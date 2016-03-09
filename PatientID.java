import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *File generates new patient id's and saves them between usages of program in file patientid.txt
 * @author Charbel
 */
public class PatientID{
    public PatientID() throws FileNotFoundException{
        /**
         * Allows us to generate patient id's and continue from where we left off (in the numbers magnitude)
         */
        in = new Scanner(new FileReader("patientid.txt"));
        if (in.hasNext()){
            g.openFile();
            patientid = in.next();
            g.closeFile();
        }
        else{
            patientid = "000000";
        }
    }
    /**
     * Returns a brand new patient id
     * @return String that holds the new patient ID 
     */
    public String getNewPatientID(){
        x = Integer.parseInt(patientid);
        x = 1 + x;
        patientid = Integer.toString(x);
        int n = 6 - patientid.length();
        if (n==6){
            idreturn = "000000";
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        if (n==5){
            idreturn = "00000" + x;
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        if (n==4){
            idreturn = "0000" + x;
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        if (n==3){
            idreturn = "000" + x;
            g.openFile();
            g.changeText(idreturn);
            g.closeFile();
            return idreturn;
        }
        if (n==2){
            idreturn = "00" + x;
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        if (n==1){
            idreturn = "0" + x;
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        if (n==0){
            idreturn = "" + x;
            g.openFile();
            g.changeText(idreturn); 
            g.closeFile();
            return idreturn;
        }
        return null;
    }
    private String patientid;
    createFile g = new createFile();
    private int x;
    private String idreturn;
    Scanner in;
}
