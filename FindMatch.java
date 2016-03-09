import java.util.ArrayList;
/**
 *File defines class FindMatch
 * @author Charbel
 */
public class FindMatch {
    /**
     * Class FindMatch takes in an ArrayList with objects of type of Fragment and an integer thresh. The Class automatically merges the nucleotide sequences that have an overlap of int thresh or more on the ends, and removes any of the sequences that are substrings of another sequence.
     * @param AllDNA An ArrayList of type Fragment .
     * @param thresh An integer that indicates the minimum number of matching nucleotides to justify a merge.
     */
        public FindMatch(ArrayList<Fragment> AllDNA, int thresh){
        threshold = thresh;
        AllDna = AllDNA;
        int size = AllDna.size() ^ 3;
        SuperLoop:for (int s = 0; s < size; s++){
            mainloop:for (int e = 0; e < size; e++){
                for(int i = 0; i < AllDna.size(); i++){
                    secondloop:for(int m = 0; m < AllDna.size(); m++){
                        if(m == i){
                            continue;
                        }
                        if(AllDna.size() == 1){
                            break mainloop;
                        }
                        String name1 = AllDna.get(i).getName();
                        String sequence1 = AllDna.get(i).getStrand();
                        String name2 = AllDna.get(m).getName();
                        String sequence2 = AllDna.get(m).getStrand();

                        if(sequence1.length() < sequence2.length()){
                            for(int c = 0; c <= sequence2.length() - sequence1.length(); c++){
                                if(sequence2.substring(c, c + sequence1.length()).equalsIgnoreCase(sequence1)){
                                    AllDna.remove(i);
                                    continue mainloop;
                                }
                            }
                        }
                        if(sequence2.length() < sequence1.length()){
                            for(int v = 0; v <= sequence1.length() - sequence2.length(); v++){
                                if(sequence1.substring(v, v + sequence2.length()).equalsIgnoreCase(sequence2)){
                                    AllDna.remove(m);
                                    continue mainloop;
                                } 
                            }
                        }                   
                    }
                }
            }
            superloop:for (int e = 0; e < size; e++){
                mainloop:for(int i = 0; i < AllDna.size(); i++){
                    secondloop:for(int m = 0; m < AllDna.size(); m++){
                        String name1 = AllDna.get(i).getName();
                        String sequence1 = AllDna.get(i).getStrand();
                        String name2 = AllDna.get(m).getName();
                        String sequence2 = AllDna.get(m).getStrand();
                        if(sequence1.contains(sequence2.substring(0, threshold))){
                            int index = sequence1.lastIndexOf(sequence2.substring(0, threshold));
                            if(sequence2.contains(sequence1.substring(index))){
                                int index2 = sequence2.indexOf(sequence1.substring(index));
                                if(index2 == 0){
                                    int y = sequence2.lastIndexOf(sequence1.substring(index));
                                    newsequence = sequence1.substring(0, index) + sequence2.substring(y);
                                    newname = name1 + name2;           
                                    newFrag = new Fragment(newname, newsequence);
                                    if(i > m){
                                        AllDna.remove(i);
                                        AllDna.remove(m);  
                                        AllDna.add(newFrag);
                                        continue secondloop;
                                    }
                                    if (m > i){
                                        AllDna.remove(m);
                                        AllDna.remove(i);  
                                        AllDna.add(newFrag);
                                        continue secondloop;
                                    }
                                }
                            }
                        }
                        if(sequence2.contains(sequence1.substring(0,threshold))){
                            int index = sequence2.lastIndexOf(sequence1.substring(0, threshold));
                            if(sequence1.contains(sequence2.substring(index))){
                                int index2 = sequence1.indexOf(sequence2.substring(index));
                                if(index2 == 0){
                                    int x = sequence1.lastIndexOf(sequence2.substring(index));
                                    newsequence = sequence2.substring(0, index) + sequence1.substring(x);
                                    newname = name1 + name2;           
                                    newFrag = new Fragment(newname, newsequence);
                                    if(i > m){
                                        AllDna.remove(i);
                                        AllDna.remove(m);  
                                        AllDna.add(newFrag);
                                        continue secondloop;
                                    }
                                    if (m > i){
                                        AllDna.remove(m);
                                        AllDna.remove(i);  
                                        AllDna.add(newFrag);
                                        continue secondloop;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    /**
     * Gets the ArrayList of merged Fragments
     * @return ArrayList of type Fragment, after being merged.
     */
    public ArrayList<Fragment> getArrayListFinalString(){
        return AllDna;
    }
    private String newsequence;
    private String newname;
    private Fragment newFrag;
    private int threshold;
    private ArrayList<Fragment> AllDna;
}
