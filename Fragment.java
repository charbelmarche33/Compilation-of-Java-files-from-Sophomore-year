/**
 * File defines class Fragment
 * @author Charbel
 */
public class Fragment {
    /**
     * Class Fragment stores information on fragments of DNA, including the name and the sequence of nucleotide bases that each contains
     * @param fragname name of fragment of DNA
     * @param frag nucleotide sequence of fragment of DNA
     */
    public Fragment(String fragname, String frag){
        name = fragname;
        fragment = frag;
    }    
    /**
     * Gets the name of the fragment
     * @return the String name of the fragment
     */
    public String getName(){
        return name;
    }
    /**
     * Gets the nucleotide sequence of the strand
     * @return the String list of nucleotides in the strand
     */
    public String getStrand(){
        return fragment;
    }
    private String name;
    private String fragment;
    }
