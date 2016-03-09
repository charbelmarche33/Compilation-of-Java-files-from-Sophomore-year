import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *File creates a ER manager in where you can input patients, sort them, order them, find the position that a patient is in (what order in line), and allows you to call on next patient.
 * @author Charbel
 */
public class ERproject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException{
        String x = "";
        int q = 1;
        PatientID id = new PatientID();
        PatientList List = new PatientList();
        PatientListOrg retList = new PatientListOrg();
        Scanner stdin = new Scanner(System.in);
        Scanner in = new Scanner("patientid.txt");
        while(q == 1){
            System.out.println("Please select your option form the folowing menu:\n \nE: Enter a new patient\n \nN: Find next patient & remove him/her from the list\n \nF: Find the position of the specific patient\n \nS: Display the list of patients sorted by priority\n \nP: Print the list of patients sorted by patient ID\n \n"
                    + "Q: Quit\n \nEnter your choice: ");
            x = stdin.next();
            if(x.toLowerCase().equals("e")){
                System.out.println("Please enter the patient's first name:");
                String firstname = stdin.next();
                System.out.println("Please enter the patient's last name:");
                String lastname = stdin.next();
                DateFormat dateformat = new SimpleDateFormat("HH:mm:ss");
                Date date = new Date();
                String theDate = dateformat.format(date);
                String PatientID = id.getNewPatientID();
                System.out.println(PatientID);
                System.out.println("Please enter the priority of the patient:");
                int priority = stdin.nextInt();
                Patient patient = new Patient(firstname, lastname, theDate, PatientID, priority);
                List.addPatient(patient);               
            }
            else if(x.toLowerCase().equals("n")){
                List.orderPatientPriority();
                List = retList.getPatientListByPriority(List);
                String[] newList = List.getPatientListByPriority();
                for(int i = 0; i < 1; i++){
                    try{
                        System.out.println((newList[i]) + " is ready to be seen." + "\n");
                        List.removePatient(List.getNextPatient());
                    }
                    catch(ArrayIndexOutOfBoundsException e){
                        System.out.println("There are no more patients!");
                    }
                }
            }
            else if(x.toLowerCase().equals("f")){
                System.out.println("Please enter first name of patient: ");
                String fn = stdin.next();
                System.out.println("Please enter last name of patient: ");
                String ln = stdin.next();
                List.orderPatientPriority();
                List = retList.getPatientListByPriority(List);
                String[] newList = List.getPatientListByPriority();
                ArrayList num = List.findPatient(fn,ln);
                System.out.println(num);
                for(int i = 0; i < num.size() ; i++){    
                    for(int s = 0; s < newList.length; s++){
                        if(num.get(i).equals(s)){ 
                            int sup = s + 1;
                            System.out.println(newList[s] + " is " + sup + "th in line." );
                        }
                    }
                }
            }
            else if(x.toLowerCase().equals("s")){
                List.orderPatientPriority();
                List = retList.getPatientListByPriority(List);
                String[] newList = List.getPatientListByPriority();
                for(int i = 0; i < newList.length; i++){
                    System.out.println(newList[i] + "\n");
                }
            }
            else if(x.toLowerCase().equals("p")){
                List.orderPatientID();
                List = retList.getPatientListByPatientID(List);
                String[] s = List.getPatientListByPatientID();
                for(int i = 0; i < s.length; i++){
                    System.out.println(s[i] + "\n");
                }
            }
            else if(x.toLowerCase().equals("q")){
                System.out.println("Thank you for using Charbel's Software");
                System.exit(0);
            }
            else{
                System.out.println("Please, re-enter your choice");
            }

        }
        
    }
}
