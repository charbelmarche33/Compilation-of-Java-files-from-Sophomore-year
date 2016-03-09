
/**
 * File is a way to feed into the patientList class 
 * @author Charbel
 */
public class PatientListOrg {
    public PatientListOrg(){
    /**
     * Orders and returns so that we can use the sorting methods in patient list.
     */    
    }
    /**
     * Takes in a patient list, organizes it by priority and returns it.
     * @param alist takes in patient list.
     * @return returns an organized patient list by priority.
     */
    public PatientList getPatientListByPriority(PatientList alist){
        alist.orderPatientPriority();
        return alist;
    }
    /**
     * Takes in a patient list, organizes it by patient id and returns it.
     * @param alist takes in patient list.
     * @return returns an organized patient list by patient id.
     */
    public PatientList getPatientListByPatientID(PatientList alist){
            alist.orderPatientID();
            return alist;
    }
}   

