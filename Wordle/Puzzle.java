import java.util.List; 
import java.util.ArrayList; 
import java.util.*; 

public class Puzzle {   
    private int correct;
    private int life;
    private String word;
    private Language lang;
    
    public Puzzle(){
        lang = new Language();
        word = lang.english();
        life = 5;
    }
    
    public void guess(String str) {
        correct = 0;
        int min = str.length();
        if (str.length()>word.length()) {
            min = word.length();
        }
        if (lang.check(str)) {
            for (int i = 0; i < min; i++) {
                if (word.substring(i,i+1).equals(str.substring(i,i+1))){
                    System.out.print("*");
                    correct++;
                } else if (word.contains(str.substring(i,i+1))){
                    System.out.print("?");
                } else {
                    System.out.print("X");
                }
            }
            this.die();
            System.out.println();
        } else {
            System.out.println ("Please Enter A Word");
        }
    }
    
    public boolean check (String str, ArrayList <String> list) {
        for (int i = 0; i < list.size()-1; i++) {
            if (list.get(i).equals(str)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isUnsolved () {
        if (correct == word.length()) {
            return false;
        }
        return true;
    }
    
    public void die () {
        life--;
    }
    
    public boolean live() {
        if (life >= 0){
            return true;
        }
        return false;
    }
    
    public String getWord(){
        return word;
    }
}