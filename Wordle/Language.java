import java.util.List; 
import java.util.ArrayList; 
import java.util.*; 
import java.io.File;
import java.io.FileNotFoundException;
public class Language {
    private ArrayList <String> strs;
    public Language() {
        strs = new ArrayList ();
        try {
            File wordfile = new File ("words.txt");
            Scanner fileScanner = new Scanner(wordfile);
            while (fileScanner.hasNext()){
                String wrd = fileScanner.nextLine();
                if(wrd.length() == 5 && !Character.isUpperCase(wrd.charAt(0)) && two(wrd)){
                    strs.add(wrd);
                }
            }
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public String english() {
        return strs.get((int)(Math.random()*strs.size()));
    }
    
    public boolean two(String str) {
        String wrd;
        for (int i = 1; i < str.length(); i++) {
            wrd = str.substring(0,i) + str.substring(i+1);
            if (wrd.contains(str.substring(i,i+1))) {
                return false;
            }
        }
        return true;
    }
    
    public boolean check(String str){
        return strs.contains(str);
    }
}

