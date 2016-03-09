import java.io.FileNotFoundException;
import java.util.*;
/**
 *File defines class ReadFile
 * @author Charbel
 */
public class ReadFile {
    /**
     * File reads the file that is specified by the constructor. This file should contain an integer at the top that tells how many different strands (name \n sequence) are in the file.
     * @param FileName A String that signifies the name of the file to be read from.
     * @throws FileNotFoundException if the file specified in FileName is not found, exception is thrown.
     * Precondition: File must exist in the project file. It should contain an integer first that describes the number of sequences in the file.
     * Postconditon: Contents should be read.
     */
     public ReadFile(String FileName) throws FileNotFoundException{
        this.AllDna = new ArrayList(0);
        FilesName = FileName; 
        Scanner in = new Scanner(new java.io.FileReader(FilesName));
        String num;
        num = in.next();
        int numb = Integer.parseInt(num);
        String name; 
        String dna;
        for(int i = 0; i < numb; i++){
            name = in.next();
            dna = in.next();
            Fragment fragment = new Fragment(name,dna);
            AllDna.add(fragment);
        }
    }
     /**
      * Gets an array list that contains objects of type Fragment.
      * @return The ArrayList containing objects of type Fragment.
      */
    public ArrayList<Fragment> getArrayOfFragments(){
        return AllDna;
    }
    private String FilesName; 
    private ArrayList<Fragment> AllDna;
}
