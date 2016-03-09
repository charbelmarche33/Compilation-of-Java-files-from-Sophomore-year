import java.util.*;
/**
 * File defines the class patient and holds information for the patient
 * @author Charbel
 */
public class Patient {

    /**
     * Stores information on the patient, including the firstname, lastname, arrivaltime, patientID, priority. Can also return information on the patients that are created.
     * @param firstname the first name of the patient
     * @param lastname the last name of the patient
     * @param arrivaltime the arrival time of the patient
     * @param patientID the ID of the patient 
     * @param priority the priority of the patient
     */
    public Patient(String firstname, String lastname, String arrivaltime, String patientID, int priority){
        firstnam = firstname;
        lastnam = lastname;
        arrivaltim = arrivaltime;
        patientid = patientID;
        prioritynum = priority;
    }
    /** 
     * gets the first name of the patient
     * @return string value that contains the patients first name
     */
    public String getFirstName(){
        return firstnam;
    }
    /**
     * gets the last name of the patient
     * @return string value that contains the patients last name
     */
    public String getLastName(){
        return lastnam;
    }
    /**
     * gets the arrival time of the patient
     * @return string value that contains the arrival time of the patient
     */
    public String getArrivalTime(){
        return arrivaltim;
    }
    /**
     * gets the patient ID assigned to the patient
     * @return string value containing the patient ID of the patient
     */
    public String getPatientID(){
        return patientid;
    }
    /**
     * gets the priority of the patient
     * @return integer value of the patient
     */
    public int getPriority(){
        return prioritynum;
    }
    private String firstnam;
    private String lastnam;
    private String arrivaltim;
    private String patientid;
    private int prioritynum;
}
