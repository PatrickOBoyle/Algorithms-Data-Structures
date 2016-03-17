import java.util.ArrayList;
import java.util.Hashtable;

public class HTAnagram extends AnagramFinder {
    // declare a hashtable with a String key, and an ArrayList of Strings as value
    public Hashtable<String, ArrayList<String> > h;

    // constructor for class
    public HTAnagram(){
        h = new Hashtable<>();
    }

    public void add(String word){
        // get base-word version of word
        String baseWord = getBaseFormOf(word);
        // declare arraylist of words
        ArrayList<String> words = new ArrayList<>();

        // if their already exists this key, retrieve the value
        if( h.containsKey(baseWord) )
            words = h.get(baseWord);

        // add the new word to the list
        words.add(word);
        // insert the entry
        h.put(baseWord, words);
    }

    public String[] search(String word){
        // convert word to baseform
        String baseWord = getBaseFormOf(word);

        // if the word is found
        if( h.containsKey(baseWord) )
            // convert the value from arraylist to an array, and return it
            return convertArrayListToArray( h.get(baseWord) );
        else{
            // if not found, return an empty String array
            return new String[0];
        }
    }

    private String[] convertArrayListToArray(ArrayList<String> arrayList){
        // create the array
        String[] array = new String[arrayList.size()];
        // set the values of array
        array = arrayList.toArray(array);

        return array;
    }
}
