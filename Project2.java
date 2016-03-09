import java.util.*;
import java.io.FileNotFoundException;

/**
 *File that takes in a file containing a set of nucleotide strands with names and a minimum threshold and then merges all the strands that overlap with one another by at least the threshold or greater (at the ends), and removes all the strands that are substrands of another strand.
 * @author Charbel
 */
public class Project2 {

    /**
     * @param args the command line arguments
     * Precondition: The threshold should not be longer than any of the strands in the file
     * Postcondition: The program should merge as much as it can
     */
    public static void main(String[] args) throws FileNotFoundException{
        try{
            Scanner stdin = new Scanner(System.in);
            System.out.println("Please enter threshold: ");
            int threshold = stdin.nextInt();
            System.out.println("Please enter the name of the input file: ");
            String filename = stdin.next();
            ReadFile TheReader =  new ReadFile(filename);
            ArrayList<Fragment> AllDNA = new ArrayList();
            AllDNA = TheReader.getArrayOfFragments();
            FindMatch finals = new FindMatch(AllDNA, threshold);
            AllDNA = finals.getArrayListFinalString();
            if(AllDNA.size() == 1){
                System.out.println("Success! \n" + AllDNA.get(0).getName()+ ": "+ AllDNA.get(0).getStrand());
            }
            else{
                System.out.println("Failure: \n");
                for(int i = 0; i < AllDNA.size(); i++){
                    String name = AllDNA.get(i).getName();
                    String strand = AllDNA.get(i).getStrand();
                    System.out.println(name + ": " + strand);
                }
            }
        }
        catch(StringIndexOutOfBoundsException e){
            System.out.println("You entered a threshold that is too large for the strands.");
        }

    }   
}
