import java.util.*;
/**
 *http://www.programmingsimplified.com/java/source-code/java-program-to-bubble-sort referenced or lines 15-44
 * @author Charbel
 */

public class PatientList {
    /**
     * PatientList stores the patients in an array, gets the next Patient, removes patient from list, orders the patients by patient number and priority, and finds the location
     */
    public PatientList(){
        n=0;
        List = new Patient[999];
    }
    /**
     * adds a patient to the patient list
     * @param patient (of type patient)
     */
    public void addPatient(Patient patient){
        List[n]=patient; 
        n=n + 1;
    }
    /**
     * orders the patient by priority
     */
    public void orderPatientPriority(){
        int c, d;
        Patient swap;
        
        for (c = 0; c <= (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                if (List[d].getPriority() < List[d+1].getPriority()){
                    swap = List[d];
                    List[d] = (List[d+1]);
                    List[d+1] = swap;
                }
            }
        }
    }
    /**
     * orders patient by patient ID
     */
    public void orderPatientID(){
        int c, d;
        Patient swap;
        
        for (c = 0; c <= (n - 1); c++) {
            for (d = 0; d < n - c - 1; d++) {
                int u = Integer.parseInt(List[d+1].getPatientID());
                int w = Integer.parseInt(List[d].getPatientID());
                if (u < w) {
                  swap = List[d];
                  List[d] = List[d+1];
                  List[d+1] = swap;
                }
            }
        }
    }
    /**
     * gets the next patient in the list
     * @return the patient that was the highest priority and came in first (among those in the priority)
     */
    public Patient getNextPatient(){
        return List[0];
    }
    /**
     * removes a patient from the array
     * @param patient 
     */
    public void removePatient(Patient patient){
        for (int i = 0; i < n; i++) {
                if (List[i].equals(patient)) {
                    if (List[i].equals(patient)) {
                        List[i] = null;
                    }
                }
        }
        for(int i = 0; i < n; i++){
                List[i] = List[i+1];
            }
        n = n - 1;    
    }
    /**
     * 
     * @param Firstname (of type string)
     * @param Secondname (of type string)
     * @return ArrayList that has all the patients that match the name being searched for
     */ 
    public ArrayList findPatient(String Firstname, String Secondname){
        String PatientID = "";
        int numofmatch = 0;
        int i;
        ArrayList match = new ArrayList(0);
        for (i = 0; i < n; i++) {
                if (List[i].getFirstName().toLowerCase().equals(Firstname.toLowerCase())) {
                    if (List[i].getLastName().toLowerCase().equals(Secondname.toLowerCase())) {
                        numofmatch++;
                        match.add(i);
                    }
                }
        }
        return match;
    }
    /**
     * Gets the patient list sorted by priority.
     * @return a string array that has a string for each patient (the first being the highest priority) that contains the priority, the patient id, the time entered, their last name, and their first name.
     */
    public String[] getPatientListByPriority(){
        String[] list = new String[n];
        int i = 0;
        for(int num = 0; num < n; num++){
            String fn = List[num].getFirstName();
            String ln = List[num].getLastName();
            String patID = List[num].getPatientID();
            String time = List[num].getArrivalTime();
            int priority = List[num].getPriority();
            list[i] = (priority + " " + patID + " " + time + "   " + ln + "," + fn);  
            i++;
        }
        return list;
    }
    /**
     * Gets the patient list sorted by patient ID.
     * @return a string array that has a string for each patient (the first being the one with the smallest patient id) that contains priority, the patient id, the time entered, their last name, and their first name.
     */
    public String[] getPatientListByPatientID(){
        String[] list = new String[n];
        int i = 0;
        for(int num = 0; num < n; num++){
            String fn = List[num].getFirstName();
            String ln = List[num].getLastName();
            String patID = List[num].getPatientID();
            String time = List[num].getArrivalTime();
            int priority = List[num].getPriority();
            list[i] = (priority + " " + patID + " " + time + "   " + ln + "," + fn);  
            i++;
        }
        return list;
    }
    private Patient[] List;
    public int n;
    Patient patient1;
    Patient patient2;
    int count = 0;
}
